package com.example.ac2.service.contract;

import java.util.List;

import com.example.ac2.dto.AgendaDTO;

public interface AgendaServiceContract {
    List<AgendaDTO> findAll();
    void create(AgendaDTO agenda);
    List<AgendaDTO> findByProfessor(String nomeProfessor);
}
