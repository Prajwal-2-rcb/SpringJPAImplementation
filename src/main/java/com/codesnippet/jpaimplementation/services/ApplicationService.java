package com.codesnippet.jpaimplementation.services;


import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.entities.Application;
import com.codesnippet.jpaimplementation.repositories.ApplicantRepository;
import com.codesnippet.jpaimplementation.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final ApplicantRepository applicantRepository;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
    }

    public Application saveApplication(Long applicantId, Application application) {
        Optional<Applicant> applicationOptional = applicantRepository.findById(applicantId);
        if (applicationOptional.isPresent()) {
            Applicant applicant = applicationOptional.get();
            application.setApplicant(applicant);
            return applicationRepository.save(application);
        }
        else{
            throw new RuntimeException("Applicant not found with id " + applicantId);
        }

    }
}
