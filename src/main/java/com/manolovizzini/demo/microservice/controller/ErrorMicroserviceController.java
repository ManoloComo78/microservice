package com.manolovizzini.demo.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
@RestController
public class ErrorMicroserviceController implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ErrorMicroserviceController.class);

    public ErrorMicroserviceController() {
    }

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String subject = "Microservice - Error Page: " + statusCode;

        final String message = exception == null ? "N/A" : exception.getMessage();
        final String body = "<html>" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Microservice 1.0-SNAPSHOT</title>\n" +
                "    <link href=\"welcome.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "</head>" +
                "<body>" +
                "<h2>" + subject + "</h2>" +
                "<div>Status code: <b>" + statusCode + "</b></div>" +
                "<div>Exception Message: <b>" + message + "</b></div>" +
                "</body>" +
                "</html>";
        logger.error(message);
        return body;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
