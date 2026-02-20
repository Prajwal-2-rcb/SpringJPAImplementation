package com.codesnippet.jpaimplementation.services;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.entities.Job;
import com.codesnippet.jpaimplementation.repositories.ApplicantJPARepository;
import com.codesnippet.jpaimplementation.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;

    private ApplicantJPARepository applicantJPARepository;

    public JobService(JobRepository jobRepository, ApplicantJPARepository applicantRepository) {
        this.jobRepository = jobRepository;
        this.applicantJPARepository = applicantRepository;
    }

    public Job createJob(Job job)
    {
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicantId, Long jobId)
    {
        Optional<Applicant> applicantOptional = applicantJPARepository.findById(applicantId);
        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if(applicantOptional.isPresent() && jobOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            Job job = jobOptional.get();
            applicant.getJobs().add(job);
            applicantJPARepository.save(applicant);
            return applicant;
        }
        else{
            throw new RuntimeException("Applicant not found with id " + applicantId);
        }
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).get();
    }
}
