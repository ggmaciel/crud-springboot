package com.gustavo.crud.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.crud.entities.Disciplina;
import com.gustavo.crud.services.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

	@Autowired
	DisciplinaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> find(@PathVariable Long id) {
		Disciplina obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Disciplina> alocarProfessor(@PathVariable Long id, 
			@RequestParam(value = "professor_id") Long professor_id) {
		
		Disciplina disciplina = service.alocarProfessor(id, professor_id);
		
		return ResponseEntity.ok(disciplina);
	}
	
	@PutMapping(value = "/{id}/matricular_aluno", params = "aluno_id")
	public ResponseEntity<Disciplina> matricularAluno(@PathVariable Long id, @RequestParam Long aluno_id) {
		Disciplina disciplina = service.matricularAluno(id, aluno_id);
		
		return ResponseEntity.ok(disciplina);
	}
}
