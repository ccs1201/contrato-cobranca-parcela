package br.com.ccs.contratocobrancaparcela.api.controllers;

import br.com.ccs.contratocobrancaparcela.services.ParcelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/parcelas")
@RequiredArgsConstructor
public class ParcelaController {

    private final ParcelaService service;

    @PutMapping("/{id}")
    public void atualizarParcela(@PathVariable UUID id) {
        service.updateValor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarParcela(@PathVariable UUID id) {
        service.delete(id);
    }
}

