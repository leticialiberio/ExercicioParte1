package org.example.servico;

import org.example.dominio.Agendamento;
import org.example.dominio.Cliente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ExportarAgendamentos {
    private static Agendar agendamentos;

    public static void main(String[] args) throws IOException {
        Path caminho = Paths.get("/C:/Users/letic/Documents/atendimentos_ddMMyyyy.cvs");

        private static List<Agendamento> exportarCVSAgendamentos(Agendar agendamentos){
            if (!caminho.toFile().exists()) {
                caminho.toFile().createNewFile();
            }
            try {
                BufferedWriter writer = Files.newBufferedWriter(caminho, StandardOpenOption.APPEND);
                String texto = String.format("%s", agendamentos.imprimirAgenda());
                writer.write(texto);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
