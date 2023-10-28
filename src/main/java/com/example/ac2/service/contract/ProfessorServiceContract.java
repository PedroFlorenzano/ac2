package com.example.ac2.service.contract;

import java.util.List;
import com.example.ac2.dto.ProfessorDTO;
import com.example.ac2.dto.UpdateListLongDTO;

public interface ProfessorServiceContract {
    List<ProfessorDTO> findAll();
    void create(ProfessorDTO professor);
    void update(Long id, UpdateListLongDTO cursoList);
    Boolean login(String nome, String cpf);
}
