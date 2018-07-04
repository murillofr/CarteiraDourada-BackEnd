package com.carteiraDourada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carteiraDourada.models.InfracaoUsuario;
import com.carteiraDourada.models.Usuario;
import com.carteiraDourada.models.Veiculo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InfracaoUsuarioRepository extends JpaRepository<InfracaoUsuario, Integer> {

    @Query("SELECT max(t.instante) FROM InfracaoUsuario t where t.usuario.id = :id")
    public Date lastInfracao(@Param("id") Integer id);

}