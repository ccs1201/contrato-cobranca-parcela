package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.entities.listeners.AuditoriaParcelaListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@EntityListeners(AuditoriaParcelaListener.class)
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Positive
    private int numero;

    @Positive
    private BigDecimal valor;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean paga;

    @Future
    @NotNull
    @Column(nullable = false)
    private LocalDate dataVencimento;

    @PastOrPresent
    private LocalDate dataPagamento;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cobranca_id")
    @NotNull
    private Cobranca cobranca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id")
    @NotNull
    private Contrato contrato;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entityId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Enumerated(EnumType.STRING)
    private List<Auditoria> auditorias = new ArrayList<>();

    @Override
    public String toString() {
        return "Parcela{" +
                "numero= " + numero +
                ", valor= " + valor +
                '}';
    }

    public void setCobranca(@NotNull Cobranca cobranca) {
        this.cobranca = cobranca;
        cobranca.addParcela(this);
    }
}