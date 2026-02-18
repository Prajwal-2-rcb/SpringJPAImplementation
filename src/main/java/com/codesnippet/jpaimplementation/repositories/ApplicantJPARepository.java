package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantJPARepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByStatusOrderByNameAsc(String status);
}
