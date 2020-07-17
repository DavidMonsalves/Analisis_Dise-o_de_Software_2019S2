package com.InstanTecnic.demo.Mensajeria.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.InstanTecnic.demo.Autentificacion.Servicios.UserServicio;
import com.InstanTecnic.demo.Autentificacion.util.JwtUtil;
import com.InstanTecnic.demo.Mensajeria.Modelos.Pago;
import com.InstanTecnic.demo.Mensajeria.Servicio.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pago")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PagoController{
    @Autowired
    PagoService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/pago")
    public boolean crear(@RequestBody @Valid Pago pago){
        return servicio.crear(pago);
    }
}
