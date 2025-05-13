package com.myplacenow.MyPlaceNow.service;

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
		    
	        LocalDateTime dataHoraAtual = LocalDateTime.now();
		latitudeLongitudeModel.setDataLatitudeLongitude(dataHoraAtual);
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
