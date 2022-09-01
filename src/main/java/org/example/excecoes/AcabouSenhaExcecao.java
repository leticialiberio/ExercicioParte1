package org.example.excecoes;

public class AcabouSenhaExcecao extends Exception {
    public AcabouSenhaExcecao() {
        super("As senhas de hoje acabaram. Os agendamentos para hoje estão encerrados! :( ");
    }
}
