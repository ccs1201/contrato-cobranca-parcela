package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.enums.EnumOperacaoAuditoria;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID entityId;
    private EnumOperacaoAuditoria operacao;
    private String log;
    @CreationTimestamp
    private LocalDateTime data;
}