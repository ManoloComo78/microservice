package com.manolovizzini.demo.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@Controller
public class ErrorMicroserviceController implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ErrorMicroserviceController.class);

    public ErrorMicroserviceController() {
    }

    @GetMapping("/error")
    public String viewError(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String subject = "Microservice - Error Page: " + statusCode;
        String message = exception == null ? "N/A" : exception.getMessage();

        model.addAttribute("title", subject);
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("message", message);
        logger.error(message);
        logger.error("cicco");
        return "error";
    }


    @Override
    public String getErrorPath() {
        return "redirect:/error";
    }
}
