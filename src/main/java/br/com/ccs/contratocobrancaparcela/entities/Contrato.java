package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.entities.listeners.AuditoriaContratoListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@EntityListeners(AuditoriaContratoListener.class)
@Getter
@Setter
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "contrato", orphanRemoval = true)
    private Cobranca cobranca;

    private int numeroParcelas;
}
