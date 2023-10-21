package com.example.ac2.service.contract;

import java.util.List;
import com.example.ac2.dto.ProfessorDTO;

public interface ProfessorServiceContract {
    List<ProfessorDTO> findAll();
    void create(ProfessorDTO professor);
}
