package com.InstanTecnic.demo.Autentificacion.Controladores;

import com.InstanTecnic.demo.Autentificacion.Modelos.AuthenticationRequest;
import com.InstanTecnic.demo.Autentificacion.Modelos.AuthenticationResponse;
import com.InstanTecnic.demo.Autentificacion.Servicios.MyUserDetailsServicio;
import com.InstanTecnic.demo.Autentificacion.util.JwtUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthControlador{

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsServicio userServicio;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/autentificar")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest request) throws Exception{
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Usuario o contraseña incorrecto", e);
        }
        final UserDetails userDetails = userServicio.loadUserByUsername(request.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/crear")
    public Boolean crearUsuario(@RequestBody AuthenticationRequest request){
        return userServicio.crear(request);
    }

    @GetMapping("/autentificar")
    public String obtenerTipoPorNombre(@RequestHeader("Authorization") String jwt,@RequestParam(name="username", required=true) String username){
        return userServicio.obtenerTipo(username);
    }

    @GetMapping("/autentificar2")
    public String obtenerTipo(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        String nombre = jwtUtil.extractUsername(jwt);
        return userServicio.obtenerTipo(nombre);
    }

    @GetMapping("/ObtenerId")
    public long obtenerid(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        final long id = jwtUtil.extractId(jwt);
        return id;
    }
}
