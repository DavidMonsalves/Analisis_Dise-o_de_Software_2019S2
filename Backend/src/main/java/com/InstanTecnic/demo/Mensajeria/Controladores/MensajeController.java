package com.InstanTecnic.demo.Mensajeria.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.InstanTecnic.demo.Autentificacion.Modelos.User;
import com.InstanTecnic.demo.Autentificacion.Servicios.UserServicio;
import com.InstanTecnic.demo.Autentificacion.util.JwtUtil;
import com.InstanTecnic.demo.Mensajeria.Entidades.MensajeRequest;
import com.InstanTecnic.demo.Mensajeria.Modelos.Mensaje;
import com.InstanTecnic.demo.Mensajeria.Servicio.MensajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/mensaje")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MensajeController{
    @Autowired
    @Qualifier("serviciomensaje")
    MensajeService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserServicio userService;

    @GetMapping("/{consulta}/{id}")
    public List<Mensaje> obtenerMayorId(@PathVariable("id") long id, @PathVariable("consulta") long consulta){

        return servicio.obtenerMayorId(id, consulta);
    }

    @PostMapping("/mensaje")
    public boolean agregarMensaje(@RequestBody @Valid MensajeRequest mensajerRequest, @RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        final long id = jwtUtil.extractId(jwt);

        Mensaje mensaje = new Mensaje(0, mensajerRequest.getMensaje(), mensajerRequest.getConsulta(), id);

        return servicio.crear(mensaje);
    }

}
