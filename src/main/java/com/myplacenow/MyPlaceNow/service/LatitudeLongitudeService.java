package com.myplacenow.MyPlaceNow.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplacenow.MyPlaceNow.model.LatitudeLongitudeModel;
import com.myplacenow.MyPlaceNow.repository.LatitudeLongitudeRepository;

@Service
public class LatitudeLongitudeService {

	
	@Autowired
	private LatitudeLongitudeRepository latitudeLongitudeRepository;

	public LatitudeLongitudeModel save(LatitudeLongitudeModel latitudeLongitudeModel) {
		
		ZoneId zonaBrasil = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime agoraComFuso = ZonedDateTime.now(zonaBrasil);
		LocalDateTime dataHoraBrasil = agoraComFuso.toLocalDateTime();

		latitudeLongitudeModel.setDataLatitudeLongitude(dataHoraBrasil);
		return latitudeLongitudeRepository.save(latitudeLongitudeModel);
	}
	
	
	/*
	 * 
	 * 	public List<FornecedorModel> fornecedorByAll() {
		return fornecedorRepository.findAll();
	}

	 * */
	 
	public List<LatitudeLongitudeModel>  getPlace() {
		
		 return latitudeLongitudeRepository.findAll();
	}
	
	

}
