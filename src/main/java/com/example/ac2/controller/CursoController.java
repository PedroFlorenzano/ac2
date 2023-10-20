package com.example.ac2.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.model.Curso;
import com.example.ac2.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> findAllCurso(){
        return cursoService.findAll();
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso){
        return cursoService.create(curso);
    }
}
