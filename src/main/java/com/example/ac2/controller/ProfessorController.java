package com.example.ac2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ac2.dto.ProfessorDTO;
import com.example.ac2.model.Professor;
import com.example.ac2.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping
    public List<ProfessorDTO> findAllProfessor(){
        return professorService.findAll();
    }

    @PostMapping
    public void createProfessor(@RequestBody ProfessorDTO professor){
        professorService.create(professor);
    }
    
}
