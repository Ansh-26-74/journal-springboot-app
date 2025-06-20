package com.AnshSpringBootProjects.JournalApplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("health-check")
    public String healthCheck() {
        return "Application is in good health";
    }

}
