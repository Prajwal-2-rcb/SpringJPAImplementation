package com.codesnippet.jpaimplementation.repositories;

import com.codesnippet.jpaimplementation.entities.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant, Long> {
}
