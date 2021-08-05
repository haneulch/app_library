package kr.stam.app.tour_spot.service;

import java.util.List;

import kr.stam.app.entity.TourSpot;

public interface TourSpotService {

	void saveAll(List<TourSpot> tours);

	void save(TourSpot mapToEntity);

	void deleteAll();
}