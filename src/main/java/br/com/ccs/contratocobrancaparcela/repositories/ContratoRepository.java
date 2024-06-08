package br.com.ccs.contratocobrancaparcela.repositories;

import br.com.ccs.contratocobrancaparcela.entities.Contrato;
import br.com.ccs.contratocobrancaparcela.repositories.projections.resumocontrato.ResumoContrato;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, UUID> {

    @EntityGraph(attributePaths = {"cobranca.parcelas"})
    Optional<Contrato> findWithParcelasById(UUID id);

    @Query("SELECT c FROM Contrato c LEFT JOIN FETCH c.cobranca LEFT JOIN FETCH c.cobranca.parcelas p " +
            "where c.id= :id order by p.numero")
    Optional<ResumoContrato> findResumoContratoById(UUID id);
}
