package com.gustavo.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.crud.entities.Aluno;
import com.gustavo.crud.entities.Disciplina;
import com.gustavo.crud.entities.Professor;
import com.gustavo.crud.repositories.DisciplinaRepository;
import com.gustavo.crud.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repo;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	AlunoService alunoService;
	
	public Disciplina find(Long id) {
		Optional<Disciplina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	}
	
	public Disciplina alocarProfessor(Long id, Long professor_id) {
			Professor prof = professorService.find(professor_id);
			Disciplina disciplina = repo.findById(id).orElseThrow(() -> 
			new ObjectNotFoundException("Disciplina não encontrada"));
			disciplina.setProfessor(prof);
			return repo.save(disciplina);
	}
	
	public Disciplina matricularAluno(Long id, Long aluno_id) {
		Aluno aluno = alunoService.find(aluno_id);
		Disciplina disciplina = find(id);
		disciplina.getAlunos().add(aluno);
		aluno.getDisciplinas().add(disciplina);
		alunoService.salvarAluno(aluno);
		
		return repo.save(disciplina);
	}
	
}
