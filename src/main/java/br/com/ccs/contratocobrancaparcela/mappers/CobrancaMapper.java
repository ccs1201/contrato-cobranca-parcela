package br.com.ccs.contratocobrancaparcela.mappers;

import br.com.ccs.contratocobrancaparcela.api.response.CobracaResponse;
import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CobrancaMapper")
public class CobrancaMapper extends AbstractMapper<CobracaResponse, Object, Cobranca> {
}
