package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.auditoria.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import jakarta.persistence.PostPersist;

import java.time.LocalDateTime;

public class AuditoriaContratoListener {

    @PostPersist
    public void postPersist(Contrato contrato) {
        Auditoria.registrarAuditoria("INSERT",
                LocalDateTime.now(), contrato.getId().toString(), contrato);
    }
}