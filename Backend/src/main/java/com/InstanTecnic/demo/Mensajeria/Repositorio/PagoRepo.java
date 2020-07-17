package com.InstanTecnic.demo.Mensajeria.Repositorio;

import java.io.Serializable;
import java.util.List;

import com.InstanTecnic.demo.Mensajeria.Modelos.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepo extends JpaRepository<Pago, Serializable>{

    //public abstract List<Pago> findByTecnico(long tecnico);
}
