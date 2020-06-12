package com.epam.esm.controller;

import com.epam.esm.CertificateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class CertificateController {
    CertificateService service = new CertificateService();
    @GetMapping
    public String sayHello() {
        return "Hello from Spring 5 and embedded Tomcat 8!";
    }
}