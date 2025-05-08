package com.myplacenow.MyPlaceNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myplacenow.MyPlaceNow.model.LatitudeLongitudeModel;

@Repository
public interface LatitudeLongitudeRepository extends JpaRepository<LatitudeLongitudeModel, Long>{
	
	

}
