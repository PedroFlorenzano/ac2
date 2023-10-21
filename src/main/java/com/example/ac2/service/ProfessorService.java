package com.example.ac2.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dto.ProfessorDTO;
import com.example.ac2.model.Professor;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.service.contract.ProfessorServiceContract;

@Service
public class ProfessorService implements ProfessorServiceContract {

    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    @Override
    public List<ProfessorDTO> findAll() {
        return professorRepository.findAll().stream().map(
            (Professor professor) -> {
                List<Long> cursosIds = professor.getCursoList().stream()
                    .map(curso -> curso.getId())
                    .collect(Collectors.toList());
            
                return ProfessorDTO.builder()
                    .id(professor.getId())
                    .nome(professor.getNome())
                    .cpf(professor.getCpf())
                    .rg(professor.getRg())
                    .endereco(professor.getCelular())
                    .cursoList(cursosIds)
                    .build();
            })
            .collect(Collectors.toList());
        
    }

    @Override
    public void create(ProfessorDTO professor){

        Professor professorSaved = Professor.builder()
            .id(professor.getId())
            .nome(professor.getNome())
            .cpf(professor.getCpf())
            .rg(professor.getRg())
            .endereco(professor.getCelular())
            //Passar lista de cursos
            //.cursoList(professor.getCursoList())
            .build();
        
        professorRepository.save(professorSaved);
}
    
}
