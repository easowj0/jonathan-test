package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/api"})
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        logger.info("IP Address: {}", ipAddress);
        return "Hello, World!";
    }
}