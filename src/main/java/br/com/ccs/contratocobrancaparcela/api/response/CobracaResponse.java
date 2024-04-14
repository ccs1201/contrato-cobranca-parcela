package br.com.ccs.contratocobrancaparcela.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
public class CobracaResponse {
    private UUID id;
    private Collection<ParcelaResponse> parcelas;
}
