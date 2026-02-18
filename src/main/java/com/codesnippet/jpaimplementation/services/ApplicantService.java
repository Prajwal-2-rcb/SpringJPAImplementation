package com.codesnippet.jpaimplementation.services;

import com.codesnippet.jpaimplementation.entities.Applicant;
import com.codesnippet.jpaimplementation.repositories.ApplicantJPARepository;
import com.codesnippet.jpaimplementation.repositories.ApplicantListCrudRepository;
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

    private final ApplicantListCrudRepository applicantListCrudRepository;

    private final ApplicantJPARepository applicantJPARepository;

    public ApplicantService(ApplicantRepository applicantRepository,ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository,
                            ApplicantListCrudRepository applicantListCrudRepository,
                            ApplicantJPARepository applicantJPARepository) {
        this.applicantRepository = applicantRepository;
        this.applicantPagingAndSortingRepository = applicantPagingAndSortingRepository;
        this.applicantListCrudRepository = applicantListCrudRepository;
        this.applicantJPARepository = applicantJPARepository;
    }

    public  Applicant saveApplicantCrud(Applicant applicant) {
        return applicantRepository.save(applicant);

    }

    public  List<Applicant> getAllApplicants() {
//        Iterable<Applicant> all=applicantRepository.findAll();
//        List<Applicant> applicantList=new ArrayList<Applicant>();
//        all.forEach(applicantList::add);
//        return applicantList;
        return applicantListCrudRepository.findAll();

    }

    public Iterable<Applicant> getApplicantWithPagination(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page, size));

    }

    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJPARepository.findByStatusOrderByNameAsc(status);
    }

    public List<Applicant> getApplicantByPartialName(String name) {
        return applicantJPARepository.findApplicantsByPartialName(name);
    }
}
