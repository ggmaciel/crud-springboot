package com.gustavo.crud.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends User {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer faltas;
	private String curso;
	private String numMatricula;
	private Integer moduloAtual;
	
	@ManyToMany(mappedBy = "alunos")
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@OneToMany
	private Set<Trabalhos> trabalhos = new HashSet<>();
	
	public Aluno() {
		
	}

	public Aluno(String nome, String email, String senha, String telefone, Long id, Integer faltas, String curso, String numMatricula, Integer moduloAtual) {
		super(nome, email, senha, telefone);
		this.id = id;
		this.faltas = faltas;
		this.curso = curso;
		this.numMatricula = numMatricula;
		this.moduloAtual = moduloAtual;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public Integer getModuloAtual() {
		return moduloAtual;
	}

	public void setModuloAtual(Integer moduloAtual) {
		this.moduloAtual = moduloAtual;
	}
	

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public Set<Trabalhos> getTrabalhos() {
		return trabalhos;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", faltas=" + faltas + ", curso=" + curso + ", numMatricula=" + numMatricula
				+ ", moduloAtual=" + moduloAtual + ", getNome()=" + getNome() + ", getEmail()=" + getEmail()
				+ ", getSenha()=" + getSenha() + ", getTelefone()=" + getTelefone() + "]";
	}
	
	
}
