package com.carteiraDourada.models.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InfracaoUsuarioResponse {

    private Integer id;

    private String usuario;

    private String infracaoId;
    
    private String infracaoNome;

    private String veiculo;

    private Date instante;

    public InfracaoUsuarioResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getInfracaoId() {
        return infracaoId;
    }

    public void setInfracaoId(String infracao) {
        this.infracaoId = infracao;
    }
    
    public String getInfracaoNome() {
        return infracaoNome;
    }

    public void setInfracaoNome(String infracao) {
        this.infracaoNome = infracao;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }
}
