package br.com.ccs.contratocobrancaparcela.controllers;

import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import br.com.ccs.contratocobrancaparcela.records.RecParcela;
import br.com.ccs.contratocobrancaparcela.services.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contrato")
@RequiredArgsConstructor
public class ContratoController {
    private final ContratoService service;

    @PostMapping
    public Contrato test() {
        return service.criarContrato();
    }

    @GetMapping("/{id}/parcelas")
    public List<RecParcela> getParcelas(@PathVariable UUID id) {
        return RecParcela.toList(service.getParcelas(id));
    }
}
