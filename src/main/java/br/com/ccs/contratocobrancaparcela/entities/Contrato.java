package br.com.ccs.contratocobrancaparcela.entities;

import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.CascadeType;

import java.util.UUID;

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cobranca cobranca;

    private int numeroParcelas;
}
