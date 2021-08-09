package kr.library.app.visited_place.service;

import java.util.List;
import kr.library.app.dto.VisitedPlaceRequest;
import kr.library.app.entity.VisitedPlace;

public interface VisitedPlaceService {

	public List<VisitedPlace> findByUsername(String username);

	public void deleteById(int seq);

	public void save(VisitedPlaceRequest request);
	
	public List<VisitedPlace> findVisitedPlaceByUsername(String username);
}
