package com.codesnippet.jpaimplementation.controllers;


import com.codesnippet.jpaimplementation.entities.Application;
import com.codesnippet.jpaimplementation.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/{applicantId}")
    public ResponseEntity<Application> addApplication(@PathVariable Long applicantId, @RequestBody Application application) {
        applicationService.saveApplication(applicantId,application);
        return ResponseEntity.ok(application);
    }
}
