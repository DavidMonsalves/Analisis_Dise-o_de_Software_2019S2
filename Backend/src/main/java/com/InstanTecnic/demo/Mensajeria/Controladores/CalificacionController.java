package com.InstanTecnic.demo.Mensajeria.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.InstanTecnic.demo.Autentificacion.Servicios.UserServicio;
import com.InstanTecnic.demo.Autentificacion.util.JwtUtil;
import com.InstanTecnic.demo.Mensajeria.Modelos.Calificacion;
import com.InstanTecnic.demo.Mensajeria.Servicio.CalificacionService;

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
@RequestMapping("v1/calificacion")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CalificacionController{
    @Autowired
    CalificacionService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/calificacion")
    public boolean crear(@RequestBody @Valid Calificacion calificacion){
        return servicio.crear(calificacion);
    }

    @GetMapping("/getAll")
    public List<Calificacion> crear(@RequestHeader("Authorization") String jwt){
        return servicio.obtenerAll();
    }
}
