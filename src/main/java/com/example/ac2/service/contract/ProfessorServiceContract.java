package com.example.ac2.service.contract;

import java.util.List;

import com.example.ac2.model.Professor;

public interface ProfessorServiceContract {
    List<Professor> findAll();
    Professor create(Professor professor);
}
