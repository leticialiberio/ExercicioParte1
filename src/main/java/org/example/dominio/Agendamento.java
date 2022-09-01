package org.example.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
public class Agendamento {
    private Cliente cliente;
    private String identificador;
    private LocalDateTime horario;
}
