package kr.stam.app.visited_place.service;

import java.util.List;
import kr.stam.app.entity.VisitedPlace;

public interface VisitedPlaceCustomRepository {
	List<VisitedPlace> findVisitedPlaceByUsername(String username);
}
