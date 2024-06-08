package br.com.ccs.contratocobrancaparcela.api.controllers;

import br.com.ccs.contratocobrancaparcela.api.response.ContratoResponse;
import br.com.ccs.contratocobrancaparcela.api.response.ParcelaResponse;
import br.com.ccs.contratocobrancaparcela.mappers.ContratoMapper;
import br.com.ccs.contratocobrancaparcela.mappers.ParcelaMapper;
import br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato.ResumoContrato;
import br.com.ccs.contratocobrancaparcela.services.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/contrato")
@RequiredArgsConstructor
public class ContratoController {
    private final ContratoService service;
    private final ContratoMapper contratoMapper;
    private final ParcelaMapper parcelaMapper;

    @PostMapping
    public ContratoResponse post() {
        return contratoMapper.toResponseModel(service.criarContrato());
    }

    @GetMapping("/{id}/parcelas")
    public Collection<ParcelaResponse> getParcelas(@PathVariable UUID id) {
        return parcelaMapper.toCollection(service.getParcelas(id));
    }

    @GetMapping("/{id}")
    public ContratoResponse getContrato(@PathVariable UUID id) {
        return contratoMapper.toResponseModel(service.getContratoComParcelas(id));
    }

    @GetMapping("/{id}/resumo")
    public ResumoContrato getResumoContrato(@PathVariable UUID id) {
        return service.getResumoContrato(id);
    }

    @PostMapping("/{id}/parcelas/adiciona")
    public ContratoResponse adicionaParcela(@PathVariable UUID id) {
        return contratoMapper.toResponseModel(service.adicionaParcela(id));
    }
}
