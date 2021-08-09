package kr.library.app.tour_spot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.library.app.entity.TourSpot;

@Repository
public interface TourSpotRepository extends JpaRepository<TourSpot, Integer>{
	
}
