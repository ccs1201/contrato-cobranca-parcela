package br.com.ccs.contratocobrancaparcela.entities.listeners;

import br.com.ccs.contratocobrancaparcela.entities.Auditoria;
import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import br.com.ccs.contratocobrancaparcela.enums.EnumOperacaoAuditoria;
import br.com.ccs.contratocobrancaparcela.services.auditoria.AuditoriaService;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuditoriaParcelaListener {

    @PrePersist
    public void prePersist(Parcela parcela) {
        AuditoriaService.logar(EnumOperacaoAuditoria.INCLUSAO,
                LocalDateTime.now(), parcela.getId(), parcela);
        createAuditoria(parcela, EnumOperacaoAuditoria.INCLUSAO);
    }

    @PreUpdate
    public void preUpdate(Parcela parcela) {
        AuditoriaService.logar(EnumOperacaoAuditoria.ALTERACAO,
                LocalDateTime.now(), parcela.getId(), parcela);
        createAuditoria(parcela, EnumOperacaoAuditoria.ALTERACAO);
    }

    private void createAuditoria(Parcela parcela, EnumOperacaoAuditoria enumOperacaoAuditoria) {
        parcela.getAuditorias().add(Auditoria.builder()
                .entityId(parcela.getId())
                .operacao(enumOperacaoAuditoria)
                .log(parcela.toString())
                .build());
    }
}