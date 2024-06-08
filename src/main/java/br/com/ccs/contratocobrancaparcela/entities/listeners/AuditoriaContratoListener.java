package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import br.com.ccs.contratocobrancaparcela.enums.EnumOperacaoAuditoria;
import br.com.ccs.contratocobrancaparcela.services.auditoria.AuditoriaService;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@RequiredArgsConstructor
public class AuditoriaContratoListener {

    @PostPersist
    public void postPersist(Contrato contrato) {
        AuditoriaService.logar(EnumOperacaoAuditoria.INCLUSAO,
                LocalDateTime.now(), contrato.getId(), contrato);
    }

    @PostUpdate
    public void postUpdate(Contrato contrato) {
        AuditoriaService.logar(EnumOperacaoAuditoria.INCLUSAO,
                LocalDateTime.now(), contrato.getId(), contrato);
    }
}