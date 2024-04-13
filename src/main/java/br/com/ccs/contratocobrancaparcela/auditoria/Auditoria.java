package br.com.ccs.contratocobrancaparcela.auditoria;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
@Slf4j
public class Auditoria {

    public static void registrarAuditoria(String operacao, LocalDateTime dataHora, String id, Object object) {
        log.info("Operação: " + operacao + ", Data/Hora: " + dataHora + ", Class Type: " + object.getClass().getSimpleName() + ", id: " + id);
    }
}