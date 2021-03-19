package com.gustavo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gustavo.crud.entities.Aluno;
import com.gustavo.crud.repositories.AlunoRepository;
import com.gustavo.crud.services.exceptions.DataIntegrityException;
import com.gustavo.crud.services.exceptions.ObjectNotFoundException;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;

	public Aluno find(Long id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
	
	public List<Aluno> findAll() {
		List<Aluno> obj = repo.findAll();
		return obj;
	}
	
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Aluno alterarSenha(Long id, String senha) {
		Aluno aluno = find(id);
		aluno.setSenha(senha);
		return repo.save(aluno);
	}
	
	public Aluno alterarTelefone(Long id, String telefone) {
		Aluno aluno = find(id);
		aluno.setTelefone(telefone);
		return repo.save(aluno);
	}
	
	public Aluno atribuirFalta(Long id) {
		Aluno aluno = find(id);
		aluno.setFaltas(aluno.getFaltas() + 1);
		return repo.save(aluno);
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return repo.save(aluno);
	}
	
	public void deletarAluno(Long id) {
		try {
			find(id);
			repo.deleteById(id);
		} catch(DataIntegrityViolationException err) {
			throw new DataIntegrityException("Não é possivel deletar entidade associada a outras");
		}
	}
}
