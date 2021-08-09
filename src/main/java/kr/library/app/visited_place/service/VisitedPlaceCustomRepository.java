package kr.library.app.visited_place.service;

import java.util.List;
import kr.library.app.entity.VisitedPlace;

public interface VisitedPlaceCustomRepository {
	List<VisitedPlace> findVisitedPlaceByUsername(String username);
}
