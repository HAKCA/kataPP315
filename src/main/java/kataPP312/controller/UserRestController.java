package kataPP312.controller;

import kataPP312.model.User;
import kataPP312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest")
public class UserRestController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authorized")
    public User getAuthorizedUser(Principal principal) {
        return userService.findUserByUsername(principal.getName());
    }
}