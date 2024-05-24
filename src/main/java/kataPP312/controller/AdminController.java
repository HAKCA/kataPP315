package kataPP312.controller;


import kataPP312.model.User;
import kataPP312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String usersPage(Model model, Principal principal){
        if(principal != null) {
            User user = userService.findUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }

        return "adminpanel";
    }


}
