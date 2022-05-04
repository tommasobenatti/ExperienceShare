package dev.tommasobenatti.experienceshare.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageErrorController implements ErrorController {

    @RequestMapping("/404")
    public String handleError() {
        return "error/404";
    }

    public String getErrorPath() {
        return "404";
    }
}
