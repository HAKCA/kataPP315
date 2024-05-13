package kataPP312.controller;


import kataPP312.model.User;
import kataPP312.service.RoleService;
import kataPP312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.findAll());

        return "users";
    }

    @GetMapping("/create")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("role", roleService.getAllUser());
        return "create";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.save(user);

        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User userById = userService.getById(id);
        model.addAttribute("user", userById);
        model.addAttribute("roles", roleService.getAllUser());
        return "edit";
    }

    @PutMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("users")
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteById(id);

        return "redirect:/admin";

    }
}
