package com.gustavo.crud.entities;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_trabalhos")
public class Trabalhos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Disciplina disciplina;
	
	private Float primeiraNota;
	private Float segundaNota;
	private Float notaAtividades;
	
	public Trabalhos() {
		
	}

	public Trabalhos(Long id, Disciplina disciplina, Float primeiraNota, Float segundaNota, Float notaAtividades) {
		super();
		this.id = id;
		this.disciplina = disciplina;
		this.primeiraNota = primeiraNota;
		this.segundaNota = segundaNota;
		this.notaAtividades = notaAtividades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina.getNome();
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Float getPrimeiraNota() {
		return primeiraNota;
	}

	public void setPrimeiraNota(Float primeiraNota) {
		this.primeiraNota = primeiraNota;
	}

	public Float getSegundaNota() {
		return segundaNota;
	}

	public void setSegundaNota(Float segundaNota) {
		this.segundaNota = segundaNota;
	}

	public Float getNotaAtividades() {
		return notaAtividades;
	}

	public void setNotaAtividades(Float notaAtividades) {
		this.notaAtividades = notaAtividades;
	}
	
	public String getNotaTotal() {
		Float notaTotal = (getPrimeiraNota() + getSegundaNota() + getNotaAtividades())/3;
		String nota = new DecimalFormat("##.#").format(notaTotal);
		return nota;
	}

}
