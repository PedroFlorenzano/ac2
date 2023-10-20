package com.example.ac2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.model.Curso;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.service.contract.CursoServiceContract;

@Service
public class CursoService implements CursoServiceContract {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }  

    @Override
    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }
    
}
