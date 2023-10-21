package com.example.ac2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dto.CursoDTO;
import com.example.ac2.model.Curso;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.service.contract.CursoServiceContract;

@Service
public class CursoService implements CursoServiceContract {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<CursoDTO> findAll() {
        return cursoRepository.findAll().stream().map(
        (Curso curso) -> {
            List<Long> professorIds = curso.getProfessorList().stream()
                    .map(professor -> professor.getId())
                    .collect(Collectors.toList());

            return CursoDTO.builder()
                    .id(curso.getId())
                    .descricao(curso.getDescricao())
                    .cargaHoraria(curso.getCargaHoraria())
                    .objetivo(curso.getObjetivo())
                    .ementa(curso.getEmenta())
                    .professorList(professorIds)
                    .build();
        })
        .collect(Collectors.toList());
    }


    //Fazer método para inserir um professor ou mais em um curso (PUT)
    @Override
    public void create(CursoDTO curso) {
        Curso cursoSaved = Curso.builder()
            .id(curso.getId())
            .descricao(curso.getDescricao())
            .cargaHoraria(curso.getCargaHoraria())
            .objetivo(curso.getObjetivo())
            .ementa(curso.getEmenta())
            .build();

        cursoRepository.save(cursoSaved);

    }

}
