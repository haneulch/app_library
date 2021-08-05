package kr.stam.app.place.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.stam.app.dto.PlaceRequest;
import kr.stam.app.entity.Place;

@Service
public class PlaceServiceImpl implements PlaceService {

	PlaceRepository placeRepository;

	PlaceServiceImpl(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	@Override
	public List<Place> findByName(String name) {
		return placeRepository.findByNameContaining(name);
	}

	@Override
	public void deleteById(int seq) {
		placeRepository.deleteById(seq);
	}

	@Override
	public int save(PlaceRequest request) {
		Place place;
		if( request.getSeq() != 0) {
			place = placeRepository.getOne(request.getSeq());
			place.setSeq(request.getSeq());
		} else {
			place = new Place();
		}
		place.setAddress(request.getAddress());
		place.setName(request.getName());
		placeRepository.save(place);
		placeRepository.flush();
		
		return place.getSeq();
	}

	@Override
	public Page<Place> findByNameWithPage(String name, Pageable page) {
		return placeRepository.findByNameContaining(name, page);
	}
}
