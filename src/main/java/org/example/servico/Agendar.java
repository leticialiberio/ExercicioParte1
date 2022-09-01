package org.example.servico;

import org.example.dominio.Agendamento;
import org.example.dominio.Cliente;
import org.example.excecoes.AcabouSenhaExcecao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agendar {
    private List<Agendamento> agendamentos;
    public Agendar() {
        agendamentos = new ArrayList<>();
    }

    public Agendamento realizarAgendamento(Cliente cliente) throws AcabouSenhaExcecao{
        Agendamento agendamento = new Agendamento();
        LocalDateTime horarioAtendimento = agendarProximoHorario();
        agendamento.setHorario(horarioAtendimento);
        agendamento.setIdentificador(DateTimeFormatter.ofPattern("yyyyMMddHHmm").format(horarioAtendimento));
        agendamentos.add(agendamento);
        return agendamento;
    }

    public String imprimirAgenda() {
        Iterator<Agendamento> iterator = agendamentos.iterator();
        StringBuilder builder = new StringBuilder();
        if (iterator.hasNext()) {
            builder.append(
                    String.format("Dia do atendimento:%s", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(agendamentos.get(0).getHorario())));
    }
    builder.append("Identificador do Agendamento \t Nome do Cliente \t Horário do atendimento \n");
    return builder.toString();
    }

    public LocalDateTime agendarProximoHorario() throws AcabouSenhaExcecao {
        LocalDateTime localDateTime = null;
        //verifica se já tem 32 senhas geradas
        if (agendamentos.size() == 2) {
            throw new AcabouSenhaExcecao();
        }
        // se a lista está vazia
        if (agendamentos.isEmpty()) {
            localDateTime = LocalDate.now().atTime(8, 0);
        } else {
            Agendamento ultimoagendamento = agendamentos.get(agendamentos.size() - 1);
            localDateTime = ultimoagendamento.getHorario().plusMinutes(15);
        }
        return localDateTime;
    }
}