package com.gustavo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.crud.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
