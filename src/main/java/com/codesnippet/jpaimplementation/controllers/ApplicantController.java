package com.codesnippet.jpaimplementation.controllers;


import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.services.ApplicantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicantCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantWithPagination(@RequestParam int page, @RequestParam int size) {
        return applicantService.getApplicantWithPagination(page,size);
    }



}
