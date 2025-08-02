package com.myplacenow.MyPlaceNow.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mp3_whatszap")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsZapModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "mp3_id_whatszap")
	private Long idWhatszap;

	@Column(name = "mp3_mensagen_whatszap")
	private String mensagenWhatszap;

	@Column(name = "mp3_numero_whatszap")
	private String numeroWhatszap;
	
	@Column(name = "mp3_usuario_whatszap")
	private String usuarioWhatszap;
	
	@Column(name = "mp3_data_whatszap")
	private LocalDateTime dataWhatszap;

	@OneToOne
    @JoinColumn(name = "mp2_id_usuario", nullable = true) 
    private UsuarioModel usuario;

}
