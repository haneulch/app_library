package kr.stam.app.tour_spot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.stam.app.entity.TourSpot;

@Repository
public interface TourSpotRepository extends JpaRepository<TourSpot, Integer>{
	
}
