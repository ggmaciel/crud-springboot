package com.gustavo.crud.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends User {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public Professor() {
		
	}
	
	public Professor(String nome, String email, String senha, String telefone, Long id) {
		super(nome, email, senha, telefone);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", getNome()=" + getNome() + ", getEmail()=" + getEmail() + ", getSenha()="
				+ getSenha() + ", getTelefone()=" + getTelefone() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
