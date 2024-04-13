package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.auditoria.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class AuditoriaContratoListener {

    @PrePersist
    public void prePersist(Contrato contrato) {
        // Chamada para registrar a auditoria
        Auditoria.registrarAuditoria("INSERT", LocalDateTime.now(), contrato.getId().toString(), contrato);
    }
}