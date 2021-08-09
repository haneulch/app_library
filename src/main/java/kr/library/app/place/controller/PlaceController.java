package kr.library.app.place.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.library.app.dto.PlaceRequest;
import kr.library.app.entity.Place;
import kr.library.app.place.service.PlaceService;
import kr.library.core.util.JsonResponseUtils;

@Controller
@RequestMapping("/place")
public class PlaceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	final PlaceService placeService;

	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@PostMapping("/create")
	public ResponseEntity<PlaceRequest> create(@RequestBody PlaceRequest request) {

		int seq = placeService.save(request);
		request.setSeq(seq);
		return new JsonResponseUtils<PlaceRequest>(request);
	}

	@PostMapping("/findByName")
	public ResponseEntity<List<Place>> findByName(@RequestBody PlaceRequest request) {

		List<Place> places = placeService.findByName(request.getName());
		return new JsonResponseUtils<List<Place>>(places);
	}

	@PostMapping("/findByNameWithPage")
	public ResponseEntity<Page<Place>> findByNameWithPage(@RequestBody PlaceRequest request) {

		Pageable page = PageRequest.of(request.getPage(), 10);

		Page<Place> places = placeService.findByNameWithPage(request.getSearch(), page);
		return new JsonResponseUtils<Page<Place>>(places);
	}

	@PostMapping("/delete")
	public ResponseEntity<Map<String, Object>> delete(@RequestBody PlaceRequest request) {

		placeService.deleteById(request.getSeq());
		return JsonResponseUtils.success(true);
	}
}