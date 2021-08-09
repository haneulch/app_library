package kr.library.app.visited_place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.library.app.dto.VisitedPlaceRequest;
import kr.library.app.entity.VisitedPlace;

@Service
public class VisitedPlaceServiceImpl implements VisitedPlaceService {

	VisitedPlaceRepository visitedPlaceRepository;

	VisitedPlaceServiceImpl(VisitedPlaceRepository visitedPlaceRepository) {
		this.visitedPlaceRepository = visitedPlaceRepository;
	}

	@Override
	public List<VisitedPlace> findByUsername(String username) {
		return visitedPlaceRepository.findByUsername(username);
	}

	@Override
	public void deleteById(int seq) {
		visitedPlaceRepository.deleteById(seq);
	}

	@Override
	public void save(VisitedPlaceRequest request) {
		VisitedPlace visitedPlace = new VisitedPlace(request.getUsername());
		visitedPlaceRepository.save(visitedPlace);
	}

	@Override
	public List<VisitedPlace> findVisitedPlaceByUsername(String username) {
		return visitedPlaceRepository.findVisitedPlaceByUsername(username);
	}
}
