package com.example.ac2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dto.AgendaDTO;
import com.example.ac2.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }
    
    @GetMapping
    public List<AgendaDTO> findAllAgenda(){
        return agendaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createAgenda(@RequestBody AgendaDTO agenda){
        agendaService.create(agenda);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/professor")
    public List<AgendaDTO> findAllAgendaByProfessor(String nomeProfessor){
        return agendaService.findByProfessor(nomeProfessor);
    }
}
