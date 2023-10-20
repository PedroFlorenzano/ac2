package com.example.ac2.service.contract;

import java.util.List;

import com.example.ac2.model.Curso;

public interface CursoServiceContract {
    List<Curso> findAll();
    Curso create(Curso curso);
}
