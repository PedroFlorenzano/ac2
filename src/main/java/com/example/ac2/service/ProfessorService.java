package com.example.ac2.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }
    
}
