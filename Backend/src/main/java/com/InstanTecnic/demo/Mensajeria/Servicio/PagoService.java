package com.InstanTecnic.demo.Mensajeria.Servicio;

import java.util.List;

import com.InstanTecnic.demo.Mensajeria.Modelos.Pago;
import com.InstanTecnic.demo.Mensajeria.Repositorio.PagoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService{
    @Autowired
    PagoRepo repositorio;

    public boolean crear(Pago pago){
        try{
            repositorio.save(pago);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
