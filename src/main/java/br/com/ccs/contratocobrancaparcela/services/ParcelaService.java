package br.com.ccs.contratocobrancaparcela.services;

import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import br.com.ccs.contratocobrancaparcela.repositories.ParcelaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParcelaService {

    private final ParcelaRepository repository;

    @Transactional
    public Parcela updateValor(UUID id) {
        var parcela = findById(id);
        parcela.setValor(parcela.getValor().add(BigDecimal.TEN));
        return repository.save(parcela);
    }

    public Parcela findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parcela nao encontrada."));
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
