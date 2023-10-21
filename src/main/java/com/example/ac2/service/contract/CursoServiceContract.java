package com.example.ac2.service.contract;

import java.util.List;
import com.example.ac2.dto.CursoDTO;

public interface CursoServiceContract {
    List<CursoDTO> findAll();
    void create(CursoDTO curso);
}
