package com.carteiraDourada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiraDourada.models.Infracao;
import com.carteiraDourada.models.Usuario;
import com.carteiraDourada.models.Response.UsuarioResponse;
import com.carteiraDourada.repositories.InfracaoRepository;
import com.carteiraDourada.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfracaoService {

    @Autowired
    private InfracaoRepository repo;

    @Autowired
    private VeiculoService veiculoService;

    public List<Infracao> findAll() {
        List<Infracao> infracoes = repo.findAll();
        return infracoes;
    }

    public Optional<Infracao> findById(Integer id) {
        Optional<Infracao> infracao = repo.findById(id);
        return infracao;
    }

    public Infracao insert(Infracao obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }
}
