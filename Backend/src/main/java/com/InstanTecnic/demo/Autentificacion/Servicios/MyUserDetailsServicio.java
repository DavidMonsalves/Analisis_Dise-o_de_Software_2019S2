package com.InstanTecnic.demo.Autentificacion.Servicios;

import java.util.Optional;

import com.InstanTecnic.demo.Autentificacion.Modelos.AuthenticationRequest;
import com.InstanTecnic.demo.Autentificacion.Modelos.MyUserDetails;
import com.InstanTecnic.demo.Autentificacion.Modelos.User;
import com.InstanTecnic.demo.Autentificacion.Repositorios.UserRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServicio implements UserDetailsService{

    @Autowired
    UserRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> user = repositorio.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("No se encontro a: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public Boolean crear(AuthenticationRequest request){
        User usuario = new User();
        usuario.setUserName(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setTipo(request.getTipo());
        try{
            repositorio.save(usuario);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String obtenerTipo(String username){
        Optional<User> usuario = repositorio.findByUserName(username);
        return usuario.map(MyUserDetails::new).get().getTipo();
    }
}
