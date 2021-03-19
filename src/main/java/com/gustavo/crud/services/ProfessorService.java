package com.gustavo.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.crud.entities.Professor;
import com.gustavo.crud.repositories.ProfessorRepository;
import com.gustavo.crud.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repo;
	
	public Professor find(Long professor_id) {
		Professor prof = repo.findById(professor_id).orElseThrow(
				() -> new ObjectNotFoundException("Professor não encontrado"));
		return prof;
	}
}
