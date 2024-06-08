package br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato;

import java.util.UUID;

public interface ResumoContrato {
    UUID getId();

    Integer getNumeroParcelas();

    ResumoCobranca getCobranca();
}




