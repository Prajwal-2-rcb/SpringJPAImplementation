package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
}
