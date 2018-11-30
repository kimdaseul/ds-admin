package com.ds.admin.dsadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(value = "/")
    public String loginPage() {
        return "home";
    }
}
