package com.example.newspaperapp.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/journalistic")
public class JournalisticController {
    @GetMapping
    public String get() {
        return "GET:: journalistic controller";
    }

    @PostMapping
    public String post() {
        return "POST:: journalistic controller";
    }

    @PutMapping
    public String put() {
        return "PUT:: journalistic controller";
    }

    @DeleteMapping
    public String delete() {
        return "DELETE:: journalistic controller";
    }
}
