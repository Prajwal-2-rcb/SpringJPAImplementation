package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicantJPARepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByStatusOrderByNameAsc(String status);


    @Query("SELECT a from Applicant a where a.name like %:name%")
    List<Applicant> findApplicantsByPartialName(String name);
}


