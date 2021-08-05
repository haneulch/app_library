package kr.stam.app.place.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.stam.app.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
	List<Place> findByNameContaining(String name);
	Page<Place> findByNameContaining(String name, Pageable page);
}
