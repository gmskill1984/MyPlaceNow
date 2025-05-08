package com.myplacenow.MyPlaceNow.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mp2_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "mp2_id_usuario")
	private Long idUsuario;

	@Column(name = "mp2_nome_usuario")
	private String nomeUsuario;

	@Column(name = "mp2_email_usuario")
	private String emailUsuario;
	
	@Column(name = "mp2_senha_usuario")
	private String senhaUsuario;

	@OneToOne(mappedBy = "usuario")
    private LatitudeLongitudeModel latitudeLongitude;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public LatitudeLongitudeModel getLatitudeLongitude() {
		return latitudeLongitude;
	}

	public void setLatitudeLongitude(LatitudeLongitudeModel latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}
	
	
	
}
