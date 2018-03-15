package com.spain.cvet.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Usuarios;
import com.spain.cvet.service.UsuariosService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuariosService usuariosService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = usuariosService.getUserByUsername(username);
		return buildUserForAuthentication(usuario);
	}
	
	private User buildUserForAuthentication(Usuarios usuario) {
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		return new User(usuario.getUsuario(), usuario.getPassword(),
			true, true, true, true, Arrays.asList(authority));
	}

}
