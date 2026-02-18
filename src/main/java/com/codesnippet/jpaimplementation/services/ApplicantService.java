package com.codesnippet.jpaimplementation.services;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.repositories.ApplicantPagingAndSortingRepository;
import com.codesnippet.jpaimplementation.repositories.ApplicantRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;

    public ApplicantService(ApplicantRepository applicantRepository,ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository) {
        this.applicantRepository = applicantRepository;
        this.applicantPagingAndSortingRepository = applicantPagingAndSortingRepository;
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

    public Iterable<Applicant> getApplicantWithPagination(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page, size));

    }
}
