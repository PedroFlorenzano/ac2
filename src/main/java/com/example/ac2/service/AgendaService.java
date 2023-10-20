package com.example.ac2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dto.AgendaDTO;
import com.example.ac2.model.Agenda;
import com.example.ac2.model.Curso;
import com.example.ac2.model.Professor;
import com.example.ac2.repository.AgendaRepository;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;
import com.example.ac2.service.contract.AgendaServiceContract;

@Service
public class AgendaService implements AgendaServiceContract {

    private AgendaRepository agendaRepository;

    private ProfessorRepository professorRepository;

    private CursoRepository cursoRepository;

    public AgendaService(AgendaRepository agendaRepository, ProfessorRepository professorRepository,
            CursoRepository cursoRepository) {
        this.agendaRepository = agendaRepository;
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<AgendaDTO> findAll() {
        return agendaRepository.findAll().stream().map(
                (Agenda agenda) -> AgendaDTO.builder()
                        .id(agenda.getId())
                        .dataInicio(agenda.getDataInicio())
                        .dataFim(agenda.getDataFim())
                        .horarioInicio(agenda.getHorarioInicio())
                        .horarioFim(agenda.getHorarioFim())
                        .estado(agenda.getEstado())
                        .cidade(agenda.getCidade())
                        .cep(agenda.getCep())
                        .cursoId(agenda.getCurso().getId())
                        .professorId(agenda.getProfessor().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void create(AgendaDTO agenda) {
        Professor professor = professorRepository.findById(agenda.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o professor pelo ID"));
        Curso curso = cursoRepository.findById(agenda.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o curso pelo ID"));

        Agenda agendaSaved = Agenda.builder()
                .id(agenda.getId())
                .dataInicio(agenda.getDataInicio())
                .dataFim(agenda.getDataFim())
                .horarioInicio(agenda.getHorarioInicio())
                .horarioFim(agenda.getHorarioFim())
                .estado(agenda.getEstado())
                .cidade(agenda.getCidade())
                .cep(agenda.getCep())
                .curso(curso)
                .professor(professor)
                .build();

        agendaRepository.save(agendaSaved);
    }

    @Override
    public List<AgendaDTO> findByProfessor(String nomeProfessor) {
        Professor professor = professorRepository.findByNome(nomeProfessor)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o professor!"));

        return agendaRepository.findAgendaByProfessor(professor.getId()).stream().map(
                (Agenda agenda) -> AgendaDTO.builder()
                        .id(agenda.getId())
                        .dataInicio(agenda.getDataInicio())
                        .dataFim(agenda.getDataFim())
                        .horarioInicio(agenda.getHorarioInicio())
                        .horarioFim(agenda.getHorarioFim())
                        .estado(agenda.getEstado())
                        .cidade(agenda.getCidade())
                        .cep(agenda.getCep())
                        .cursoId(agenda.getCurso().getId())
                        .professorId(agenda.getProfessor().getId())
                        .build())
                .collect(Collectors.toList());
    }
}
