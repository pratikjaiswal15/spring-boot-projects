package com.springBoot.web.spring_boot_web_application.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private AuthenticationService authenticationService;

    public WelcomeController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String goToLoginPage() {
//        return "login";
//    }
//
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if(authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            model.put("password", password);
//            return "welcome";
//        }
//
//        model.put("errorMessage", "Invalid Credentials. Please try again");
//        return "login";
//    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
