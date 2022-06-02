package br.espm.cambio;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {
    // JQL - Java Query Language
    @Query("SELECT c from CotacaoModel c WHERE UPPER(c.idMoeda) = UPPER(:idMoeda)")
    Iterable<CotacaoModel> findAll(@Param("simbolo") String simbolo);

}

