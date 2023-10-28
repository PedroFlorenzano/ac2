package com.example.ac2.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Data de início não pode ser nula")
    private LocalDate dataInicio;
    @NotNull(message = "Data fim não pode ser nula")
    private LocalDate dataFim;
    @Min(value = 1, message = "Horário de ínicio não pode ser menor que 1 hora")
    private Integer horarioInicio;
    @Max(value = 24, message = "Carga horário não pode ser maior que 24 horas")
    private Integer horarioFim;
    @NotBlank(message = "Estado não pode ser vazia")
    private String estado;
    @NotBlank(message = "Cidade não pode ser vazia")
    private String cidade;
    @NotBlank(message = "Cep não pode ser vazia")
    private String cep;
    @ManyToOne
    @NotNull(message = "Curso não pode ser nulo")
    private Curso curso;
    @ManyToOne
    @NotNull(message = "Professor não pode ser nulo")
    private Professor professor;
}
