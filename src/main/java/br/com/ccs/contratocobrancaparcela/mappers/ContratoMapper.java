package br.com.ccs.contratocobrancaparcela.mappers;

import br.com.ccs.contratocobrancaparcela.api.response.ContratoResponse;
import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ContratoMapper")
public class ContratoMapper extends AbstractMapper<ContratoResponse, Object, Contrato> {
}
