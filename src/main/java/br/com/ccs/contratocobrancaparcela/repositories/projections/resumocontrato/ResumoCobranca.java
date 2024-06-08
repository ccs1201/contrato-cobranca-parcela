package br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato;

import java.util.List;

public interface ResumoCobranca {
    List<ResumoParcela> getParcelas();
}