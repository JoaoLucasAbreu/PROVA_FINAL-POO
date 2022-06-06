package br.espm.cambio;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;
    
    @Autowired
    private CotacaoService cotacaoService;


    // @GetMapping("/hello")
    // public String helloWorld() {
    //     return "Hello ESPM";
    // }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo:[A-Z]{3}}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public Moeda findMoedaById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return moedaService.findBy(uuid);
    }

    @DeleteMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public void deleteMoeda(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        moedaService.DeleteById(uuid);
    }

    @PostMapping("/moeda")
    public void saveMoeda(@RequestBody Moeda moeda) {
        moedaService.create(moeda);
    }

    @GetMapping("/cotacao/{simbolo}")
    public List<Cotacao> listCotacao(@PathVariable String simbolo){
        UUID uuid = moedaService.findBySimbolo(simbolo).getId();
        return cotacaoService.listAll(uuid);
    }   
    @PostMapping("/cotacao/{simbolo}/{ano}/{mes}/{dia}")
    public void saveCotacao(@RequestBody Cotacao cotacao, @PathVariable String simbolo, @PathVariable String ano, @PathVariable String mes, @PathVariable String dia){
        LocalDate data = LocalDate.parse(ano + "-" + mes + "-" + dia);
        cotacao.setData(data);
        UUID uuid = moedaService.findBySimbolo(simbolo).getId();
        cotacao.setIdMoeda(uuid);
        cotacaoService.create(cotacao);
    }

    
}