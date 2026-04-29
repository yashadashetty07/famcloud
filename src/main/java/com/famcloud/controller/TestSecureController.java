package com.famcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecureController {

    @GetMapping("/admin/test")
    public String adminTest() {
        return "Admin API accessed";
    }

    @GetMapping("/user/test")
    public String userTest() {
        return "User API accessed";
    }
}