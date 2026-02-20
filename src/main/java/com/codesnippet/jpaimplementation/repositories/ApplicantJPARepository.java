package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantJPARepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByStatusOrderByNameAsc(String status);


    @Query("SELECT a from Applicant a where a.name like %:name%")
    List<Applicant> findApplicantsByPartialName(@Param("name") String name);
}


