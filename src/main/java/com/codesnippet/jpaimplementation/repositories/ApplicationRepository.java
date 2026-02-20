package com.codesnippet.jpaimplementation.repositories;


import com.codesnippet.jpaimplementation.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
