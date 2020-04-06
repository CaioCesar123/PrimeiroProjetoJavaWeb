package br.com.senac.inicializar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Carro;
import br.com.senac.domain.Chave;
import br.com.senac.domain.Documento;
import br.com.senac.domain.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CarroService;
import br.com.senac.service.ChaveService;
import br.com.senac.service.DocumentoService;
import br.com.senac.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	ChaveService chaveService;
	
	@Autowired
	CarroService carroService;
	
	@Autowired
	DocumentoService documentoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Caio");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Bruno");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Thais");
		alunoService.salvar(aluno3);
		
		Professor prof = new Professor();
		prof.setNome("Marcelo");
		professorService.salvar(prof);
		
		Professor prof2 = new Professor();
		prof2.setNome("Luigi");
		professorService.salvar(prof2);
		
		Professor prof3 = new Professor();
		prof3.setNome("Mario");
		professorService.salvar(prof3);
		
		Chave chave1 = new Chave();
		chave1.setCodigo("123221");
		chaveService.save(chave1);
		
		Carro carro1 = new Carro();
		carro1.setPlaca("123UC");
		carroService.save(carro1);
		
		Documento doc1 = new Documento();
		doc1.setNumeroDoc("HG321");
		documentoService.save(doc1);
		
		List<Carro> listaCarro = carroService.ProcurarCarro();
		
		List<Documento> listaDoc = documentoService.ProcurarDocumento();
		
		List<Chave> listarChave = chaveService.ProcurarChaves();
		
		List<Professor> listarProfessors = professorService.buscartodosProfessor();
		
		List<Aluno> listarAlunos = alunoService.buscarTodosAlunos();
		
		
		
		
		for(Aluno aluno:listarAlunos) {
			System.out.println(aluno.getNome());
		}
		
		for(Professor professor:listarProfessors) {
			System.out.println(professor.getNome());			
		}
		
		
		
	}

}
