package br.com.ccs.contratocobrancaparcela.services.auditoria;

import br.com.ccs.contratocobrancaparcela.enums.EnumOperacaoAuditoria;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class AuditoriaService {

    public static void logar(EnumOperacaoAuditoria operacao, LocalDateTime dataHora, UUID id, Object object) {
        log.info("Operação: " + operacao + ", Data/Hora: " + dataHora + ", Class Type: " + object.getClass().getSimpleName() + ", id: " + id);
    }
}