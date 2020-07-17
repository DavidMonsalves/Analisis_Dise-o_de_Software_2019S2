package com.InstanTecnic.demo.Mensajeria.Repositorio;

import java.io.Serializable;
import java.util.List;

import com.InstanTecnic.demo.Mensajeria.Modelos.Consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepo extends JpaRepository<Consulta, Serializable>{

    public abstract List<Consulta> findByTecnicoOrCliente(long tecnico, long cliente);
    public abstract List<Consulta> findByAceptada(String aceptada);
}
