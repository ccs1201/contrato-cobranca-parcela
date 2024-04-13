package br.com.ccs.contratocobrancaparcela.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Cobranca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Contrato contrato;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cobranca_id")
    private List<Parcela> parcelas;


    public void setParcelas(@NotEmpty List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public void addParcela(@NotNull Parcela parcela) {
        if (this.parcelas == null) {
            this.parcelas = new ArrayList<>();
        }
        this.parcelas.add(parcela);
    }
}