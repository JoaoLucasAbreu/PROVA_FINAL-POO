package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 
 * Esse e o microservico de cotacao
 */
@Component
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public List<Cotacao> listAll(UUID id) {
        return StreamSupport
                // Transforma de iteravel para lista
                .stream(cotacaoRepository.findAll(id.toString()).spliterator(), false)
                .collect(Collectors.toList())
                // Transforma de Model para Objeto
                .stream().map(CotacaoModel::to)
                .collect(Collectors.toList());
    }

    public Cotacao create(Cotacao cotacao) {
        cotacao.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(cotacao)).to();
    }

    public Cotacao findBy(UUID id) {
        return cotacaoRepository.findById(id.toString())
                    .map(CotacaoModel::to)
                    .orElse(null);
    }
    
}
