package com.myplacenow.MyPlaceNow.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mp1_longitude_latitude")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatitudeLongitudeModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "mp1_id_longitude_latitude")
	private Long idLatitudeLongitude;

	@Column(name = "mp1_longitude_longitude_latitude")
	private Double longitudeLatitudeLongitude;

	@Column(name = "mp1_latitude_longitude_latitude")
	private Double latitudeLatitudeLongitude;
	
	@Column(name = "mp1_data_longitude_latitude")
	private LocalDateTime dataLatitudeLongitude;

	@OneToOne
    @JoinColumn(name = "mp2_id_usuario", nullable = true) 
    private UsuarioModel usuario;

	
	
	public Long getIdLatitudeLongitude() {
		return idLatitudeLongitude;
	}

	public void setIdLatitudeLongitude(Long idLatitudeLongitude) {
		this.idLatitudeLongitude = idLatitudeLongitude;
	}

	public Double getLongitudeLatitudeLongitude() {
		return longitudeLatitudeLongitude;
	}

	public void setLongitudeLatitudeLongitude(Double longitudeLatitudeLongitude) {
		this.longitudeLatitudeLongitude = longitudeLatitudeLongitude;
	}

	public Double getLatitudeLatitudeLongitude() {
		return latitudeLatitudeLongitude;
	}

	public void setLatitudeLatitudeLongitude(Double latitudeLatitudeLongitude) {
		this.latitudeLatitudeLongitude = latitudeLatitudeLongitude;
	}

	public LocalDateTime getDataLatitudeLongitude() {
		return dataLatitudeLongitude;
	}

	public void setDataLatitudeLongitude(LocalDateTime dataLatitudeLongitude) {
		this.dataLatitudeLongitude = dataLatitudeLongitude;
	}
	

	
}
