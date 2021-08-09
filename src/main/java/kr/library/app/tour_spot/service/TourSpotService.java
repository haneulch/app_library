package kr.library.app.tour_spot.service;

import java.util.List;

import kr.library.app.entity.TourSpot;

public interface TourSpotService {

	void saveAll(List<TourSpot> tours);

	void save(TourSpot mapToEntity);

	void deleteAll();
}