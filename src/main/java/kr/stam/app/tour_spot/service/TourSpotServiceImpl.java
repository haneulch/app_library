package kr.stam.app.tour_spot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.stam.app.entity.TourSpot;

@Service
public class TourSpotServiceImpl implements TourSpotService {

	final TourSpotRepository tourSpotRepository;

	public TourSpotServiceImpl(TourSpotRepository tourSpotRepository) {
		this.tourSpotRepository = tourSpotRepository;
	}

	@Override
	public void saveAll(List<TourSpot> tours) {
		tourSpotRepository.saveAll(tours);
	}

	@Override
	public void save(TourSpot tour) {
		tourSpotRepository.save(tour);
	}

	@Override
	public void deleteAll() {
		tourSpotRepository.deleteAll();
	}
}
