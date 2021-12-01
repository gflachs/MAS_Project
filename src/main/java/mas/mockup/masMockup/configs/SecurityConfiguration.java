package mas.mockup.masMockup.configs;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    /*
     * @Override
     * protected void configure(AuthenticationManagerBuilder auth) throws Exception
     * {
     * PasswordEncoder encoder =
     * passwordEncoder();
     * auth
     * .inMemoryAuthentication()
     * .withUser("user")
     * .password(encoder.encode("password"))
     * .roles("USER")
     * .and()
     * .withUser("admin")
     * .password(encoder.encode("admin"))
     * .roles("USER", "ADMIN", "CUSTOMERSERVICE")
     * .and()
     * .withUser("cs")
     * .password(encoder.encode("cs"))
     * .roles("CUSTOMERSERVICE");
     * }
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/cs/**").hasRole("CUSTOMERSERVICE")
                .antMatchers("/").permitAll()
                .antMatchers("/api/v1/**").permitAll()

                .antMatchers("/public/**").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/register*").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/dashboard")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/perform_logout", "GET"))
                .logoutSuccessUrl("/user/dashboard")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

}
