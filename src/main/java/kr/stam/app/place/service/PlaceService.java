package kr.stam.app.place.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.stam.app.dto.PlaceRequest;
import kr.stam.app.entity.Place;

public interface PlaceService {

	public List<Place> findByName(String username);

	public void deleteById(int seq);

	public int save(PlaceRequest request);

	public Page<Place> findByNameWithPage(String name, Pageable page);

}
