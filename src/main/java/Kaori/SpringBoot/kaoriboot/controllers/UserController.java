package Kaori.SpringBoot.kaoriboot.controllers;

import Kaori.SpringBoot.kaoriboot.models.User;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserController {
    @GetMapping()
    String showAll(Model model);

    @GetMapping(params = "id")
    String show(Model model, @RequestParam(name = "id") Integer id);

    @GetMapping("/create")
    String createUserForm(@ModelAttribute("user") User user);

    @PostMapping("/create")
    String create(@ModelAttribute("user") @Valid User user,
                  BindingResult bindingResult);

    @GetMapping("/update")
    String updateForm(@RequestParam(name = "id") Integer id, Model model);

    @PostMapping("/update")
    String update(@ModelAttribute("user") @Valid User user,
                  BindingResult bindingResult);

    @PostMapping("/delete")
    String delete(@RequestParam(name = "id") Integer id);
}
