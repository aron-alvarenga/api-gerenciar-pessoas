package com.aronalvarenga.avaliacaobackend.repository;

import com.aronalvarenga.avaliacaobackend.dto.EnderecosDTO;
import com.aronalvarenga.avaliacaobackend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query("SELECT new com.aronalvarenga.avaliacaobackend.dto.EnderecosDTO (e.id, e.logradouro, e.cep, e.numero,  e.cidade, e.enderecoPrincipal) FROM Pessoa p JOIN p.enderecos e")
    public List<EnderecosDTO> getJoinInfo();

    @Query("SELECT new com.aronalvarenga.avaliacaobackend.dto.EnderecosDTO (e.id, e.logradouro, e.cep, e.numero,  e.cidade, e.enderecoPrincipal) FROM Pessoa p JOIN p.enderecos e WHERE p.id = :id")
    public List<EnderecosDTO> getJoinInfoById(@Param("id") Long id);

    @Query("SELECT new com.aronalvarenga.avaliacaobackend.dto.EnderecosDTO (e.id, e.logradouro, e.cep, e.numero,  e.cidade, e.enderecoPrincipal) FROM Pessoa p JOIN p.enderecos e WHERE p.id = :id AND e.enderecoPrincipal = true")
    public List<EnderecosDTO> getJoinInfoMainById(@Param("id") Long id);

}
