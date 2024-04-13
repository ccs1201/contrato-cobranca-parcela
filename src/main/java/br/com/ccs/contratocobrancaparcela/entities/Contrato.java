package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.entities.listeners.AuditoriaContratoListener;
import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.CascadeType;

import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditoriaContratoListener.class)
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cobranca cobranca;

    private int numeroParcelas;
}
