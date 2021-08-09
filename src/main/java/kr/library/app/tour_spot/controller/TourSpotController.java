package kr.library.app.tour_spot.controller;

import static kr.library.app.constant.ApiInfoConstant.TOUR_SPOT_API_KEY;
import static kr.library.app.constant.ApiInfoConstant.TOUR_SPOT_API_PER_PAGE;
import static kr.library.app.constant.ApiInfoConstant.TOUR_SPOT_API_URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.library.app.entity.TourSpot;
import kr.library.app.tour_spot.service.TourSpotService;
import kr.library.core.util.RESTFulUtils;

@Controller
@RequestMapping("/tour_spot")
public class TourSpotController {
	
	private final TourSpotService tourSpotService;
	
	TourSpotController(TourSpotService tourSpotService) {
		this.tourSpotService = tourSpotService;
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	getTourInfo
	 * @enclosing_type				:	TourSpotController
	 * @return_type					:	String
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		전체 관광지 데이터를 불러옴
	 *
	 *
	 */
	@GetMapping("/initData")
	public String getTourInfo() {
		Map<String, Object> param = new HashMap<String, Object>();
		
		double totalCount = -1;
		int totalPage = 1;
		
		tourSpotService.deleteAll();
		
		for(int i = 1; i <= totalPage; i++) {

			param.put("serviceKey", TOUR_SPOT_API_KEY);
			param.put("page", i);
			param.put("perPage", TOUR_SPOT_API_PER_PAGE);
			
			Map<String, Object> result = RESTFulUtils.getInstance().callGet(TOUR_SPOT_API_URL, param);
			
			if( !result.isEmpty()) {
				
				if(totalCount == -1) {
					totalCount = Double.parseDouble(result.get("totalCount") + "");
					totalPage = (int) Math.ceil(totalCount/TOUR_SPOT_API_PER_PAGE);
				}
				
				saveTourSpots(result);
				
			}
		}
		return "/main/view";
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	getTourInfo
	 * @enclosing_type				:	TourSpotController
	 * @return_type					:	String
	 * @tags						:	@param request
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		페이지별 관광지 데이터를 불러옴
	 *
	 *
	 */
	@GetMapping("/getDataPerPage")
	public String getTourInfo(@RequestParam Map<String, Object> request) {
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("serviceKey", TOUR_SPOT_API_KEY);
		param.put("page", request.get("page"));
		param.put("perPage", TOUR_SPOT_API_PER_PAGE);
		
		Map<String, Object> result = RESTFulUtils.getInstance().callGet(TOUR_SPOT_API_URL, param);
		
		
		if( !result.isEmpty()) {
			saveTourSpots(result);
		}
		return "/main/view";
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	saveTourSpots
	 * @enclosing_type				:	TourSpotController
	 * @return_type					:	void
	 * @tags						:	@param result
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		데이터를 저장
	 *
	 *
	 */
	private void saveTourSpots(Map<String, Object> result) {
		List<Map<String, String>> datas = (List<Map<String, String>>) result.get("data");
		
		if(datas != null && datas.size() > 0) {
			
			List<TourSpot> tours = new ArrayList<TourSpot>();
			
			datas.stream().forEach(data -> tours.add(mapToEntity(data)));
			
			tourSpotService.saveAll(tours);
		}
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	mapToEntity
	 * @enclosing_type				:	TourSpotController
	 * @return_type					:	TourSpot
	 * @tags						:	@param tour
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		map을 Entity로 변환
	 *
	 *
	 */
	private TourSpot mapToEntity(Map<String, String> tour) {
		String[] kor = new String[] {"대분류", "중분류", "소분류", "문의및안내", "시군", "읍면동", "정보명", "주소", "지역"};
		
		TourSpot tourSpot = TourSpot.builder()
								.lClass(tour.get(kor[0]))
								.mClass(tour.get(kor[1]))
								.sClass(tour.get(kor[2]))
								.tel(tour.get(kor[3]))
								.city(tour.get(kor[4]))
								.town(tour.get(kor[5]))
								.name(tour.get(kor[6]))
								.address(tour.get(kor[7]))
								.area(tour.get(kor[8]))
							.build();
		
		return tourSpot;
	}
}
