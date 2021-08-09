package kr.library.app.visited_place.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.library.app.dto.VisitedPlaceRequest;
import kr.library.app.entity.VisitedPlace;
import kr.library.app.visited_place.service.VisitedPlaceService;
import kr.library.core.util.JsonResponseUtils;

@Controller
@RequestMapping("/visited_place")
public class VisitedPlaceController {
	
	final VisitedPlaceService visitedPlaceService;
	
	public VisitedPlaceController(VisitedPlaceService visitedPlaceService) {
		this.visitedPlaceService = visitedPlaceService;
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> create(@RequestBody VisitedPlaceRequest request) {

		visitedPlaceService.save(request);
		return JsonResponseUtils.success(true);
	}

	@PostMapping("/findByUserName")
	public ResponseEntity<List<VisitedPlace>> findByUserName(@RequestBody VisitedPlaceRequest request) {

		List<VisitedPlace> visitedPlaces = visitedPlaceService.findByUsername(request.getUsername());
//		List<VisitedPlace> visitedPlaces = visitedPlaceService.findVisitedPlaceByUsername(request.getUsername());
		return new JsonResponseUtils<List<VisitedPlace>>(visitedPlaces);
	}

	@PostMapping("/delete")
	public ResponseEntity<Map<String, Object>> delete(@RequestBody VisitedPlaceRequest request) {

		visitedPlaceService.deleteById(request.getSeq());
		return JsonResponseUtils.success(true);
	}
}
