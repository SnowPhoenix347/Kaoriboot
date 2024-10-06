package Kaori.SpringBoot.kaoriboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainControllerImpl implements MainController {
    @Override
    public String indexPage() {
        return "index";
    }
}
