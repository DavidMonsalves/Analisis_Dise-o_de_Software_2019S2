package com.InstanTecnic.demo.Mensajeria.Servicio;

import java.util.List;

import com.InstanTecnic.demo.Mensajeria.Modelos.Calificacion;
import com.InstanTecnic.demo.Mensajeria.Repositorio.CalificacionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService{
    @Autowired
    CalificacionRepo repositorio;

    public boolean crear(Calificacion calificacion){
        try{
            repositorio.save(calificacion);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public List<Calificacion> obtenerAll(){
        return repositorio.findAll();
    }

}
