package kr.library.app.book_api.controller;

import static kr.library.app.constant.ApiInfoConstant.BOOK_DETAIL_API_URL;
import static kr.library.app.constant.ApiInfoConstant.BOOK_INFO_API_KEY;
import static kr.library.app.constant.ApiInfoConstant.BOOK_INFO_API_PER_PAGE;
import static kr.library.app.constant.ApiInfoConstant.BOOK_INFO_API_RESULT_STYLE;
import static kr.library.app.constant.ApiInfoConstant.BOOK_INFO_API_URL;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.library.app.book_api.BookApiUtils;
import kr.library.app.book_api.service.BookApiService;
import kr.library.app.category.service.CategoryService;
import kr.library.app.dto.BookApiDataResponse;
import kr.library.app.dto.BookApiDetailDataResponse;
import kr.library.app.dto.BookApiResponse;
import kr.library.app.entity.BookInfo;
import kr.library.app.entity.Category;
import kr.library.core.util.JsonResponseUtils;
import kr.library.core.util.RESTFulUtils;

@Controller
@RequestMapping("/book_api")
public class BookApiController {
	private final BookApiService bookApiService;
	
	BookApiController(
			BookApiService bookApiService) {
		this.bookApiService = bookApiService;
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.07.14
	 * @enclosing_method			:	getAllBookData
	 * @enclosing_type				:	BookApiController
	 * @return_type					:	String
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.07.14		haneul		전체 책정보를 불러오 DB에 저장한다.
	 *
	 */
	@GetMapping("/getAllData")
	public String getAllBookData() {
		int page = 1;
		int totalCount = -1;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cert_key", BOOK_INFO_API_KEY);
		param.put("result_style", BOOK_INFO_API_RESULT_STYLE);
		param.put("page_no", page);
		param.put("page_size", BOOK_INFO_API_PER_PAGE);

		Map<String, Object> result = RESTFulUtils.getInstance().callGet(BOOK_INFO_API_URL, param);
		
		ObjectMapper om = new ObjectMapper();
		
		BookApiResponse apiResponse = om.convertValue(result, BookApiResponse.class);
		
		totalCount = Integer.parseInt(apiResponse.getTotalCount());
		
		if(totalCount > 0) {
			
			bookApiService.saveAll(apiResponse.getDocs());
			
			while(page * BOOK_INFO_API_PER_PAGE < totalCount) {
				page ++;
				param.put("page_no", page);
				
				result = RESTFulUtils.getInstance().callGet(BOOK_INFO_API_URL, param);
				apiResponse = om.convertValue(result, BookApiResponse.class);
				bookApiService.saveAll(apiResponse.getDocs());
			}
		}
		
		return "/main/view";
	}
	
	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.07.14
	 * @enclosing_method			:	getBookDataByIsbn
	 * @enclosing_type				:	BookApiController
	 * @return_type					:	ResponseEntity<Map<String,Object>>
	 * @tags						:	@param param
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.07.14		haneul		isbn으로 책정보 검색
	 */
	@PostMapping("/getDataByIsbn")
	public ResponseEntity<Map<String, Object>> getBookDataByIsbn(
			@RequestParam Map<String, Object> param) {
		
		BookInfo bookInfo = bookApiService.findByIsbn(param.get("isbn") + "");
		
		if(bookInfo != null) {
			return JsonResponseUtils.success(bookInfo);
		}
		
		param.put("cert_key", BOOK_INFO_API_KEY);
		param.put("result_style", BOOK_INFO_API_RESULT_STYLE);
		param.put("page_no", 1);
		param.put("page_size", BOOK_INFO_API_PER_PAGE);

		Map<String, Object> result = RESTFulUtils.getInstance().callGet(BOOK_INFO_API_URL, param);
		
		ObjectMapper om = new ObjectMapper();
		BookApiResponse apiResponse = om.convertValue(result, BookApiResponse.class);
		
		if(apiResponse != null && apiResponse.getDocs().size() > 0) {
			BookApiDataResponse bookApiData = apiResponse.getDocs().get(0);
			BookInfo book = BookApiUtils.dataToEntity(bookApiData);
			book = bookApiService.save(book);
			
			Map<String, Object> isbnMap = new HashMap<String, Object>();
			isbnMap.put("isbn", param.get("isbn"));
			Category category = apiBookDetailByIsbn(isbnMap);
			
			book.setCategorySeq(category.getSeq());
			bookApiService.updateBookInfo(book);
			
			return JsonResponseUtils.success(apiResponse.getDocs());
		}
		return JsonResponseUtils.success("검색된 정보가 없습니다.");
	}
	
	@PostMapping("/getDetailByIsbn")
	public ResponseEntity<Map<String, Object>> getBookDetailByIsbn(
			@RequestParam Map<String, Object> param) {
		apiBookDetailByIsbn(param);
		return JsonResponseUtils.success(true);
	}
	
	public Category apiBookDetailByIsbn(Map<String, Object> param) {
		param.put("key", BOOK_INFO_API_KEY);
		param.put("detailSearch", true);
		param.put("isbnOp", "isbn");
		param.put("isbnCode", param.get("isbn"));
		param.put("page_no", 1);
		param.put("apiType", "json");

		Map<String, Object> result = RESTFulUtils.getInstance().callGet(BOOK_DETAIL_API_URL, param);
		
		if(result != null) {
			ObjectMapper om = new ObjectMapper();
			BookApiDetailDataResponse apiResponse = om.convertValue(result, BookApiDetailDataResponse.class);
			
			if(apiResponse != null && apiResponse.getResult().size() > 0) {
				String cateName = apiResponse.getResult().get(0).getKdcName1s();
				
				Category category = bookApiService.findCategoryByCateName(cateName);
				
				if(category == null) {
					category = Category.builder().cateName(cateName).build();
					category = bookApiService.saveCategory(category);
				}
				
				return category;
			}
		}
		return null;
	}
}
