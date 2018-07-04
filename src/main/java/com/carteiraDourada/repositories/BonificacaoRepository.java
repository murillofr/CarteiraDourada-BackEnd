package com.carteiraDourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carteiraDourada.models.Bonificacao;

import java.util.Optional;

@Repository
public interface BonificacaoRepository extends JpaRepository<Bonificacao, Integer> {

    public Optional<Bonificacao> findByUsuario(Integer user);

}