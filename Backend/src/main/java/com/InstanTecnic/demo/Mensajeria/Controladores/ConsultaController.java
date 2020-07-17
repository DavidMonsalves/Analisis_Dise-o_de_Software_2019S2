package com.InstanTecnic.demo.Mensajeria.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.InstanTecnic.demo.Autentificacion.Servicios.UserServicio;
import com.InstanTecnic.demo.Autentificacion.util.JwtUtil;
import com.InstanTecnic.demo.Mensajeria.Modelos.Consulta;
import com.InstanTecnic.demo.Mensajeria.Servicio.ConsultaService;

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
@RequestMapping("v1/consulta")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ConsultaController{
    @Autowired
    ConsultaService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/consulta")
    public boolean crear(@RequestBody @Valid Consulta consulta){
        return servicio.crear(consulta);
    }

    @GetMapping("/consultas")
    public List<Consulta> obtenerId(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        final long id = jwtUtil.extractId(jwt);

        return servicio.obtenerAllId(id);
    }

    @GetMapping("/obtenerId")
    public long obtenerIdActual(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        final long id = jwtUtil.extractId(jwt);
        return id;
    }

    @PutMapping("/estado")
      public boolean actualizarConsulta(@RequestBody @Valid Consulta consulta){
          return servicio.actualizar(consulta);
      }

    @GetMapping("/consultatec")
      public List<Consulta> obtenerConsultas(@RequestHeader("Authorization") String jwt){
          // extraigo el usuario
          jwt = jwt.substring(7);
          return servicio.obtenerAllId_Tec("NO");
      }
}
