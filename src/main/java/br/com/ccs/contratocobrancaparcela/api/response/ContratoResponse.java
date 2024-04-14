package br.com.ccs.contratocobrancaparcela.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContratoResponse {
    private UUID id;
    private int numeroParcelas;
    private CobracaResponse cobranca;
}
