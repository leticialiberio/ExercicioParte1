package org.example;

import org.example.dominio.Agendamento;
import org.example.dominio.Cliente;
import org.example.excecoes.AcabouSenhaExcecao;
import org.example.servico.Agendar;
import org.example.servico.ExportarAgendamentos;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agendar agendar = new Agendar();
        Integer opcao = 0;
        System.out.println("Bem-vindo ao sistema de agendamentos!");
        do {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Realizar agendamento \n2 - Listar agendamentos do dia \n3 - Exportar agendamentos");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.println("Informe o CPF");
                    cliente.setCpf(scanner.next());
                    System.out.println("Informe o nome");
                    cliente.setNome(scanner.next());

                    try {
                        Agendamento agendamento = agendar.realizarAgendamento(cliente);
                        System.out.printf("Agendamento realizado com sucesso! %nAgendamento: %s em %s\n",
                                agendamento.getIdentificador(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(agendamento.getHorario()));
                    } catch (AcabouSenhaExcecao e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println(agendar.imprimirAgenda());
                    break;
                case 3:
                    System.out.println(exportarAgendamentos.exportarCVSAgendamentos());
                default:
                    System.out.println("Opçao inválida!");
                    opcao = 0;
            }
        }
        while (opcao != 0);
    }

}
