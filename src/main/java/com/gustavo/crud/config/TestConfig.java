package com.gustavo.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavo.crud.entities.Aluno;
import com.gustavo.crud.entities.Disciplina;
import com.gustavo.crud.entities.Professor;
import com.gustavo.crud.entities.Trabalhos;
import com.gustavo.crud.repositories.AlunoRepository;
import com.gustavo.crud.repositories.DisciplinaRepository;
import com.gustavo.crud.repositories.ProfessorRepository;
import com.gustavo.crud.repositories.TrabalhosRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private TrabalhosRepository trabalhosRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Aluno alu1 = new Aluno("Gustavo Araujo Maciel", "gustavoemail.gmail.com", "123456", "99999-9999", 
				null, 1, "ADS", "8452587", 1);
		
		Aluno alu2 = new Aluno("Paulo alves", "pauloalves.gmail.com", "123456", "99999-9999", 
				null, 1, "Engenharia", "8452587", 1);
		
		Professor prof1 = new Professor("Marcello", "marcello@email.com", "123456", "99999-9999", null);
		
		Professor prof2 = new Professor("Arnott", "arnott@email.com", "123456", "99999-9999", null);
		
		Disciplina dis1 = new Disciplina(null, "Banco de Dados", "18:30 ás 21:10", "NOITE", prof1, 50);
		
		Trabalhos trab1 = new Trabalhos(null, dis1, 10.0f, 5.5f, 8.0f);
		Trabalhos trab2 = new Trabalhos(null, dis1, 10.0f, 10f, 10f);
		Trabalhos trab3 = new Trabalhos(null, dis1, 5f, 3f, 2f);
		
		alunoRepository.saveAll(Arrays.asList(alu1, alu2));
		professorRepository.saveAll(Arrays.asList(prof1, prof2));
		disciplinaRepository.save(dis1);
		
		alu1.getDisciplinas().add(dis1);
		dis1.getAlunos().add(alu1);
		prof1.getDisciplinas().add(dis1);
		
		disciplinaRepository.save(dis1);
		professorRepository.save(prof1);
		
		trabalhosRepository.saveAll(Arrays.asList(trab1, trab2, trab3));
		
		alu1.getTrabalhos().addAll(Arrays.asList(trab1, trab2, trab3));
		
		
		alunoRepository.save(alu1);
		
		System.out.println("=====DADOS SALVOS=====");
		
	}

}
