package br.com.ccs.contratocobrancaparcela.mappers;

import br.com.ccs.contratocobrancaparcela.api.response.ParcelaResponse;
import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ParcelaMapper")
public class ParcelaMapper extends AbstractMapper<ParcelaResponse, Object, Parcela> {
}
