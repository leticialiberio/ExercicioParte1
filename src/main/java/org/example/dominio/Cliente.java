package org.example.dominio;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

/**
 * Sistema de diaDoAgendamento
 * Uma empresa está pedindo para você criar um sistema de diaDoAgendamento.
 * Este sistema deverá gerar 32 duas senhas em um determinado dia, ou seja, o cliente vai se cadastrar,
 * informando seu nome e cpf. O sistema deverá realizar um diaDoAgendamento deste cliente.
 * Cada diaDoAgendamento deverá ser 15 minutos após o diaDoAgendamento anterior, sendo o primeiro diaDoAgendamento
 * realizado para as 08:00 do dia corrente.
 * Ao atingir o limite de 32 agendamentos realizados, o sistema não deve permitir novos agendamentos.
 * listar os agendamentos do dia da seguinte forma:
 * <p>
 * Dia do atendimento: 07/06/2022
 * Identificador do diaDoAgendamento	Nome do cliente	Horário do atendimento
 * 573c6407	Oswald de Andrade	08:00
 * 6774ecb8	Tarsila do Amaral	08:15
 * 301f0932	Mário de Andrade	08:30
 **/

@Data
public class Cliente {
    private String nome;
    private String cpf;
}