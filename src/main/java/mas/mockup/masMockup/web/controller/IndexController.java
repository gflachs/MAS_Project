package mas.mockup.masMockup.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mas.mockup.masMockup.services.ArticleService;
import mas.mockup.masMockup.services.ProductService;
import mas.mockup.masMockup.services.UserService;
import mas.mockup.masMockup.web.database.UserBody;
import mas.mockup.masMockup.web.loginRequest.LoginRequest;

@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public String indexPage(Model model) {

        model.addAttribute("articles", articleService.findAll());

        return "Bestellung";
    }

    @GetMapping(path = "register")
    public String getRegister(Model model) {
        model.addAttribute("userbody", new UserBody());
        return "register";
    }

    @PostMapping(path = "register")
    public String perform_Registration(@ModelAttribute UserBody userBody, Model model) {
        userService.createNewUser(userBody, "USER");

        return indexPage(model);
    }

    @GetMapping(path = "login")
    public String getLogin(@RequestParam(name = "success", required = false) boolean success, Model model) {
        if (!success) {
            model.addAttribute("success", false);
        }
        return "login";
    }

    @GetMapping(path = "user/dashboard")
    public String dashboard(Model model) {
        return indexPage(model);
    }

}
