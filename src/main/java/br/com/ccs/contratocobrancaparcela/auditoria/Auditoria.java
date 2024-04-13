package br.com.ccs.contratocobrancaparcela.auditoria;

import java.time.LocalDateTime;

public class Auditoria {

    public static void registrarAuditoria(String operacao, LocalDateTime dataHora, String id, Object object) {
        // Implemente aqui a lógica para registrar a auditoria
        System.out.println("Operação: " + operacao + ", Data/Hora: " + dataHora + ", Class Type: " + object.getClass().getSimpleName() + ", id: " + id);
    }
}