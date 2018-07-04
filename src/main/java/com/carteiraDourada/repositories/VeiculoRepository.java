package com.carteiraDourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carteiraDourada.models.Usuario;
import com.carteiraDourada.models.Veiculo;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

    public List<Veiculo> findVeiculoByUsuario(Optional<Usuario> user);
}