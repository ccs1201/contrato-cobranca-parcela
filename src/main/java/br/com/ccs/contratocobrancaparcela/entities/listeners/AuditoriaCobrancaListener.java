package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.auditoria.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import jakarta.persistence.PostPersist;

import java.time.LocalDateTime;

public class AuditoriaCobrancaListener {

    @PostPersist
    public void prePersist(Cobranca cobranca) {
        Auditoria.registrarAuditoria("INSERT",
                LocalDateTime.now(), cobranca.getId().toString(), cobranca);
    }
}