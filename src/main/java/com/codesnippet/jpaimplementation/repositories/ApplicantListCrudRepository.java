package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantListCrudRepository extends ListCrudRepository<Applicant, Long> {
}
