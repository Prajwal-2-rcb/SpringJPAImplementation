package com.codesnippet.jpaimplementation.controllers;


import com.codesnippet.jpaimplementation.entities.Resume;
import com.codesnippet.jpaimplementation.services.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {

    ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId,@RequestBody Resume resume) {

        return ResponseEntity.ok(resumeService.addResume(applicantId,resume));

    }
}
