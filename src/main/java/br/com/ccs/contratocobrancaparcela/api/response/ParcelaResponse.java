package br.com.ccs.contratocobrancaparcela.api.response;

import br.com.ccs.contratocobrancaparcela.entities.Auditoria;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ParcelaResponse {
    private UUID id;
    private int numero;
    private BigDecimal valor;
    private List<Auditoria> auditorias;
}
