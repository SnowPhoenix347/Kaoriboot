package Kaori.SpringBoot.kaoriboot.controllers;

import Kaori.SpringBoot.kaoriboot.models.User;
import Kaori.SpringBoot.kaoriboot.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "showUsers";
    }

    @GetMapping(params = "id")
    public String show(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("user", userService.get(id));
        return "showUser";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "createUser";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUser";
        } else {
            userService.create(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam(name = "id") int id, Model model) {
        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "updateUser";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
