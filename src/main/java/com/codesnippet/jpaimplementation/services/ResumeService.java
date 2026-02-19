package com.codesnippet.jpaimplementation.services;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.entities.Resume;
import com.codesnippet.jpaimplementation.repositories.ApplicantJPARepository;
import com.codesnippet.jpaimplementation.repositories.ResumeRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    ResumeRepository resumeRepository;

    ApplicantJPARepository applicantJPARepository;

    public ResumeService(ResumeRepository resumeRepository,ApplicantJPARepository applicantJPARepository) {
        this.resumeRepository = resumeRepository;
        this.applicantJPARepository = applicantJPARepository;
    }

    public  Resume addResume(Long applicantId, Resume resume) {

        Optional<Applicant>  applicantOptional= applicantJPARepository.findById(applicantId);
        if(applicantOptional.isPresent()) {
            Applicant applicant=applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);

        }
        else{
            throw new RuntimeException("Applicant not found with id "+applicantId);
        }

    }
}
