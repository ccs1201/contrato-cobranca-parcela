package br.com.ccs.contratocobrancaparcela.repositories;

import br.com.ccs.contratocobrancaparcela.entities.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, UUID> {

    @Query("SELECT p FROM Parcela p join p.contrato join fetch p.auditorias WHERE p.contrato.id = :contratoId order by p.numero")
    List<Parcela> findByContratoId(UUID contratoId);
}
