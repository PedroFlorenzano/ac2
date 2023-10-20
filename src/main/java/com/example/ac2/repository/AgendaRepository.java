package com.example.ac2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

    @Query("select cc from Agenda cc left join fetch cc.professor c where cc.id = :id")
    List<Agenda> findAgendaByProfessor(@Param("id") Long id);
}
