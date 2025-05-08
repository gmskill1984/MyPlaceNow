package com.myplacenow.MyPlaceNow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myplacenow.MyPlaceNow.model.LatitudeLongitudeModel;
import com.myplacenow.MyPlaceNow.service.LatitudeLongitudeService;

@CrossOrigin
@RestController
@RequestMapping("/myplacenow/api/v1/latitudelongitude")
public class LatitudeLongitudeController {

	@Autowired
	private LatitudeLongitudeService latitudeLongitudeService;

	@PostMapping("/save")
	public ResponseEntity<LatitudeLongitudeModel> save(@RequestBody LatitudeLongitudeModel latitudeLongitudeModel ) {
		return ResponseEntity.ok(latitudeLongitudeService.save(latitudeLongitudeModel));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<LatitudeLongitudeModel>> get() {
		return ResponseEntity.ok(latitudeLongitudeService.getPlace());
	}
	
}
