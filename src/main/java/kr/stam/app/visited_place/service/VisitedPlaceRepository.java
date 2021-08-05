package kr.stam.app.visited_place.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.stam.app.entity.VisitedPlace;

@Repository
public interface VisitedPlaceRepository extends JpaRepository<VisitedPlace, Integer>, VisitedPlaceCustomRepository {
	List<VisitedPlace> findByUsername(String username);
}
