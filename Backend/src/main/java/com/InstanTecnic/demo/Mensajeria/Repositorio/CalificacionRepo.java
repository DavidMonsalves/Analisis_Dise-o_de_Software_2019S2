package com.InstanTecnic.demo.Mensajeria.Repositorio;

import java.io.Serializable;
import java.util.List;

import com.InstanTecnic.demo.Mensajeria.Modelos.Calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepo extends JpaRepository<Calificacion, Serializable>{

    public abstract List<Calificacion> findAll();
    
}
