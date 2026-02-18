package com.codesnippet.jpaimplementation.services;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public  Applicant saveApplicantCrud(Applicant applicant) {
        return applicantRepository.save(applicant);

    }

    public  List<Applicant> getAllApplicants() {
        Iterable<Applicant> all=applicantRepository.findAll();
        List<Applicant> applicantList=new ArrayList<Applicant>();
        all.forEach(applicantList::add);
        return applicantList;

    }
}
