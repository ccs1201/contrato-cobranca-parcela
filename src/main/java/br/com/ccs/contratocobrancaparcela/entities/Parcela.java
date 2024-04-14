package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.entities.listeners.AuditoriaParcelaListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditoriaParcelaListener.class)
public class Parcela {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private int numero;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "cobranca_id")
    @NotNull
    private Cobranca cobranca;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id")
    @NotNull
    private Contrato contrato;


}