package com.gustavo.crud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.crud.entities.Aluno;
import com.gustavo.crud.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> obj = service.findAll();
		
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> find(@PathVariable Long id) {
		Aluno obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
				
				return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}", params = "senha")
	public ResponseEntity<Aluno> alterarSenha(@PathVariable Long id, @RequestParam String senha) {
		
		Aluno aluno = service.alterarSenha(id, senha);
		
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping(value = "/{id}", params = "telefone")
	public ResponseEntity<Aluno> alterarTelefone(@PathVariable Long id, @RequestParam String telefone) {
		
		Aluno aluno = service.alterarTelefone(id, telefone);
		
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping(value = "/{id}/atribuirFalta")
	public ResponseEntity<Aluno> atribuirFalta(@PathVariable Long id) {
		
		Aluno aluno = service.atribuirFalta(id);
		
		return ResponseEntity.ok(aluno);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
		service.deletarAluno(id);
		
		return ResponseEntity.noContent().build();
	}

}
