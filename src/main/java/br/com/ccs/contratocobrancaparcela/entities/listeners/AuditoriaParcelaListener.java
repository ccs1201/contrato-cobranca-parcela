package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.auditoria.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import jakarta.persistence.PostPersist;

import java.time.LocalDateTime;

public class AuditoriaParcelaListener {

    @PostPersist
    public void postPersist(Parcela parcela) {
        Auditoria.registrarAuditoria("INSERT",
                LocalDateTime.now(), parcela.getId().toString(), parcela);
    }
}