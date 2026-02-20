package com.codesnippet.jpaimplementation.controllers;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.entities.Job;
import com.codesnippet.jpaimplementation.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob=jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs=jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(Long id) {
        Job job=jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PostMapping("add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId,
                                                       @RequestParam Long jobId) {
        Applicant updatedApplicant=jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(updatedApplicant);
    }
}
