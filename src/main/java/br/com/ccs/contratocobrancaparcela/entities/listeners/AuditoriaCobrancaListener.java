package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.services.auditoria.AuditoriaService;
import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import br.com.ccs.contratocobrancaparcela.enums.EnumOperacaoAuditoria;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

import java.time.LocalDateTime;

public class AuditoriaCobrancaListener {

    @PostPersist
    public void postPersist(Cobranca cobranca) {
        AuditoriaService.logar(EnumOperacaoAuditoria.INCLUSAO,
                LocalDateTime.now(), cobranca.getId(), cobranca);
    }
    @PostUpdate
    public void postUpdate(Cobranca cobranca) {
        AuditoriaService.logar(EnumOperacaoAuditoria.ALTERACAO,
                LocalDateTime.now(), cobranca.getId(), cobranca);
    }
}