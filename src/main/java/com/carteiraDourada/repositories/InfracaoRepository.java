package com.carteiraDourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carteiraDourada.models.Infracao;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Integer> {

}