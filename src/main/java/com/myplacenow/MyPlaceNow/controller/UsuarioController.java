package com.myplacenow.MyPlaceNow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplacenow.MyPlaceNow.model.LatitudeLongitudeModel;
import com.myplacenow.MyPlaceNow.model.UsuarioModel;
import com.myplacenow.MyPlaceNow.service.LatitudeLongitudeService;
import com.myplacenow.MyPlaceNow.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/myplacenow/api/v1/usuario")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/save")
	public ResponseEntity<UsuarioModel> save(UsuarioModel usuario) {
		return ResponseEntity.ok(usuarioService.save(usuario));
	}
	
	@PostMapping("/getUsuario")
	public ResponseEntity<List<UsuarioModel>> get() {
		return ResponseEntity.ok(usuarioService.getUsuario());
	}
	

}
