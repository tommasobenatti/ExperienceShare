package dev.tommasobenatti.experienceshare.rest;

import dev.tommasobenatti.experienceshare.Lang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", Lang.TITLE.getValue());
        model.addAttribute("description", Lang.DESCRIPTION.getValue());
        model.addAttribute("color", Lang.COLOR.getValue());
        model.addAttribute("pageDomain", Lang.DOMAIN.getValue());
        System.out.println(model);
        return "index";
    }
}
