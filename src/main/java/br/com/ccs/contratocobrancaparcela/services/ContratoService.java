package br.com.ccs.contratocobrancaparcela.services;

import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import br.com.ccs.contratocobrancaparcela.repositories.ContratoRepository;
import br.com.ccs.contratocobrancaparcela.repositories.ParcelaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private ParcelaRepository parcelaRepository;
    private final Random random = new Random();

    @Transactional
    public Contrato criarContrato() {
        try {
            Contrato contrato = new Contrato();
            contrato.setNumeroParcelas(random.nextInt(100));
            contrato.setCobranca(new Cobranca());
            contrato.getCobranca().setContrato(contrato);

            criarParcelas(contrato);

            return contratoRepository.save(contrato);

        } catch (Exception e) {
            log.error("Erro ao criar contrato", e);
        }

        return null;
    }

    private void criarParcelas(Contrato contrato) {

        var vlrParcela = BigDecimal.valueOf(random.nextInt(1000));

        for (int i = 1; i <= contrato.getNumeroParcelas(); i++) {

            Parcela parcela = new Parcela();
            parcela.setNumero(i);
            parcela.setValor(vlrParcela);
            parcela.setCobranca(contrato.getCobranca());
            parcela.setContrato(contrato);
            contrato.getCobranca().addParcela(parcela);
        }
    }

    @Transactional(readOnly = true)
    public List<Parcela> getParcelas(UUID contratoId) {
        return parcelaRepository.findByContratoId(contratoId);
    }
}