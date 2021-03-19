package com.gustavo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.crud.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
