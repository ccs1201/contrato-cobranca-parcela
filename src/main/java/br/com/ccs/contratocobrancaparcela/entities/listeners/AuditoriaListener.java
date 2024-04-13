package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.auditoria.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class AuditoriaListener {

    @PrePersist
    public void prePersist(Cobranca cobranca) {
        // Chamada para registrar a auditoria
        Auditoria.registrarAuditoria("INSERT", LocalDateTime.now(), cobranca.getId().toString(), cobranca);
    }
}