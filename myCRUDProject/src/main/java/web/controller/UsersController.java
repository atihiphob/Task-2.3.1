package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers (ModelMap model) {
        model.addAttribute("usersList", userService.listUsers());
        //Получим всех юзеров из бд и передадим на отображение в представление
        return "/users";
    }

    @GetMapping("/users/{id}")
    public String getUserById (Model model, @PathVariable("id") int id) {
        model.addAttribute("user",  userService.get(id));
        //Получим одного человека из бд и передадим на отображение в представление
        return "/user";
    }

    @GetMapping("/users/create_user")
    public String createUser (@ModelAttribute ("user") User user ) {
        return "/createUser";
    }

    @PostMapping ("/add")
    public String add (@ModelAttribute ("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PatchMapping("/user/{id}")
    public String update (@ModelAttribute ("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping ("/users/{id}/delete")
    public String delete (@PathVariable("id") int id) {
        userService.remove(id);
        return "redirect:/users";
    }
}
