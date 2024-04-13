package br.com.ccs.contratocobrancaparcela.repositories;

import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
}
