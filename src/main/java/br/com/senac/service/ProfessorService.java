package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Professor;
import br.com.senac.repository.ProfessorRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepositorio repoProfessor;
	
	public List<Professor> buscartodosProfessor(){
		return repoProfessor.findAll();
	}
	public Professor salvar(Professor professor) {
		return repoProfessor.save(professor);
	}
	
	public Professor buscaID(Integer id) throws ObjectNotFoundException{
		Optional<Professor> prof = repoProfessor.findById(id);
		return prof.orElseThrow(() -> new ObjectNotFoundException("Professor Não Encontrado"));
	}
	
	public Professor Alterado(Professor professorNovo) throws ObjectNotFoundException{
		Professor professor = buscaID(professorNovo.getId());
		professor.setId(professorNovo.getId());
		professor.setNome(professorNovo.getNome());
		return salvar(professor);
	}
	
	public void excluir(Integer id) {
		repoProfessor.deleteById(id);
	}

}
