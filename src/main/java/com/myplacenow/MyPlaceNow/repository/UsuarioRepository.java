package com.myplacenow.MyPlaceNow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myplacenow.MyPlaceNow.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	UsuarioModel findByEmailUsuario(String emailUsuario);
}
