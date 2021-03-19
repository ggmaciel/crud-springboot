package com.gustavo.crud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String horario;
	private String turno;
	private Integer numeroDeAlunos;
	
	@ManyToOne
	private Professor professor;
	
	@ManyToMany
	private Set<Aluno> alunos = new HashSet<>();
	
	
	public Disciplina () {
		
	}

	public Disciplina(Long id, String nome, String horario, String turno, Professor professor, Integer numeroDeAlunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.horario = horario;
		this.turno = turno;
		this.professor = professor;
		this.numeroDeAlunos = numeroDeAlunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getProfessor() {
		return professor.getNome();
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Integer getNumeroDeAlunos() {
		return numeroDeAlunos;
	}

	public void setNumeroDeAlunos(Integer numeroDeAlunos) {
		this.numeroDeAlunos = numeroDeAlunos;
	}

	@JsonIgnore
	public Set<Aluno> getAlunos() {
		return alunos;
	}

}
