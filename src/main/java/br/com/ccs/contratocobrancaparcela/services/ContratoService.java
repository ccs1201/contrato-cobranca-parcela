package br.com.ccs.contratocobrancaparcela.services;

import br.com.ccs.contratocobrancaparcela.entities.Cobranca;
import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import br.com.ccs.contratocobrancaparcela.repositories.ContratoRepository;
import br.com.ccs.contratocobrancaparcela.repositories.ParcelaRepository;
import br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato.ResumoContrato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
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
    private final Random random = new SecureRandom();

    @Transactional
    public Contrato criarContrato() {
        try {
            Contrato contrato = new Contrato();
            contrato.setNumeroParcelas(random.nextInt(10));
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
            parcela.setDataVencimento(LocalDate.now().plusMonths(i));
            parcela.setContrato(contrato);
        }
    }

    @Transactional(readOnly = true)
    public List<Parcela> getParcelas(UUID contratoId) {
        return parcelaRepository.findByContratoId(contratoId);
    }

    @Transactional(readOnly = true)
    public Contrato getContratoComParcelas(UUID id) {
        return contratoRepository.findWithParcelasById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    @Transactional(readOnly = true)
    public ResumoContrato getResumoContrato(UUID id) {
        return contratoRepository.findResumoContratoById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    @Transactional
    public Contrato adicionaParcela(UUID id) {
        var contrato = findById(id);
        var p = new Parcela();
        p.setValor(BigDecimal.TEN);
        p.setDataVencimento(LocalDate.now().plusDays(1));
        p.setNumero(9999);
        p.setContrato(contrato);
        p.setCobranca(contrato.getCobranca());

        parcelaRepository.save(p);

        return contrato;
    }

    @Transactional(readOnly = true)
    public Contrato findById(UUID id) {
        return contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }
}