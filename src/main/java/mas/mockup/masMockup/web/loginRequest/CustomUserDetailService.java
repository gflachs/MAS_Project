package mas.mockup.masMockup.web.loginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mas.mockup.masMockup.services.UserService;
import mas.mockup.masMockup.web.database.Users;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        UserDetails userDetails = User.withUsername(user.getEmail()).password(user.getPassword())
                .roles(user.getUserGroup()).build();
        return userDetails;
    }

}
