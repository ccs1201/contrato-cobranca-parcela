package br.com.ccs.contratocobrancaparcela.entities;

import br.com.ccs.contratocobrancaparcela.entities.listeners.AuditoriaCobrancaListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditoriaCobrancaListener.class)
@Getter
@Setter
public class Cobranca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Contrato contrato;

    @OneToMany(mappedBy = "cobranca", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Parcela> parcelas;

    public void addParcela(@NotNull Parcela parcela) {
        if (this.parcelas == null) {
            this.parcelas = new LinkedList<>();
        }
        this.parcelas.add(parcela);
    }
}