package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.UsuarioDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

        UsuarioDb usuario = usuarioService.getByNickname(nickname).get();
        return UsuarioPrincipal.build(usuario);
    }

}
