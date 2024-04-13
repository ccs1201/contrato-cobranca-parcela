package br.com.ccs.contratocobrancaparcela.records;

import br.com.ccs.contratocobrancaparcela.entities.Parcela;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record RecParcela(UUID id,
                         int numero,
                         BigDecimal valor) {

    public static RecParcela toRecord(Parcela parcela) {
        return new RecParcela(
                parcela.getId(),
                parcela.getNumero(),
                parcela.getValor()
        );
    }


    public static List<RecParcela> toList(List<Parcela> parcelas) {
        return parcelas.stream()
                .map(RecParcela::toRecord)
                .toList();
    }
}
