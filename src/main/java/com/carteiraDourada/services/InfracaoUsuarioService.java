package com.carteiraDourada.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiraDourada.models.Infracao;
import com.carteiraDourada.models.InfracaoUsuario;
import com.carteiraDourada.models.Response.InfracaoUsuarioResponse;
import com.carteiraDourada.repositories.InfracaoUsuarioRepository;
import com.carteiraDourada.repositories.UsuarioRepository;
import com.carteiraDourada.repositories.VeiculoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InfracaoUsuarioService {

    @Autowired
    private InfracaoUsuarioRepository repo;

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private VeiculoRepository veiculoRepo;

    public List<InfracaoUsuarioResponse> findAll() {
        List<InfracaoUsuario> infracoes = repo.findAll();
        ArrayList<InfracaoUsuarioResponse> usuariosResponse = new ArrayList<InfracaoUsuarioResponse>();

        for (int i = 0; i < infracoes.size(); i++) {
            usuariosResponse.add(this.convertToDTo(infracoes.get(i)));
        }
        return usuariosResponse;
    }

    public List<InfracaoUsuarioResponse> findById(Integer id) {
        List<InfracaoUsuario> infracoes = repo.findAll();
        ArrayList<InfracaoUsuarioResponse> usuariosResponse = new ArrayList<InfracaoUsuarioResponse>();

        for (int i = 0; i < infracoes.size(); i++) {
            if(infracoes.get(i).getUsuario().getId() == id){
                usuariosResponse.add(this.convertToDTo(infracoes.get(i)));
            }
        }
        return usuariosResponse;
    }

    public InfracaoUsuario insert(InfracaoUsuario obj) {
        obj.setId(null);
        obj.setInstante(addDays(new Date(), -5));
        obj = repo.save(obj);
        return obj;
    }

    public Date lastInfracao (Integer user){
        Date lastInfracao = repo.lastInfracao(user);
        return lastInfracao;
    }

    private InfracaoUsuarioResponse convertToDTo(InfracaoUsuario user) {
        InfracaoUsuarioResponse userDTO = new InfracaoUsuarioResponse();
        userDTO.setId(user.getId());
        userDTO.setInfracaoId(user.getInfracao().getId().toString());
        userDTO.setInfracaoNome(user.getInfracao().getNome().toString());
        userDTO.setVeiculo(user.getVeiculo().getId().toString());
        userDTO.setUsuario(user.getUsuario().getId().toString());
        userDTO.setInstante(user.getInstante());

        return userDTO;
    }

    private Date addDays(Date theDate, Integer days) {
        return new Date(theDate.getTime() + days*24*60*60*1000);
    }

}