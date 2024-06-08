package br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ResumoParcela {
    Integer getNumero();

    BigDecimal getValor();

    Boolean getPaga();

    LocalDate getDataVencimento();
}