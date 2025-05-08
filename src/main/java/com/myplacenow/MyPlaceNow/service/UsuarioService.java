package com.myplacenow.MyPlaceNow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioModel save(UsuarioModel usuario) {
		  	    
	     return usuarioRepository.save(usuario);
	}
	
	 
	public List<UsuarioModel>  getUsuario() {
		
		 return usuarioRepository.findAll();
	}
}
