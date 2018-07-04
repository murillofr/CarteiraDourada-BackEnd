package com.carteiraDourada.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carteiraDourada.models.Bonificacao;
import com.carteiraDourada.services.BonificacaoService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/bonificacoes")
public class BonificacaoResource {

    @Autowired
    private BonificacaoService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Bonificacao>> findById(@PathVariable Integer id) {

        Optional<Bonificacao> infracao = service.findBonificacaoByUser(id);

        return ResponseEntity.ok().body(infracao);
    }

}
