package com.gustavo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.crud.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
