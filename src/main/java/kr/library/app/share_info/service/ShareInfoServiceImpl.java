package kr.library.app.share_info.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.library.app.dto.ShareInfoRequest;
import kr.library.app.entity.BookInfo;
import kr.library.app.entity.ShareInfo;
import kr.library.core.entity.User;

@Service
@Transactional
public class ShareInfoServiceImpl implements ShareInfoService {
	@PersistenceContext
	EntityManager em;
	
	private final ShareInfoRepository shareInfoRepository;
	
	public ShareInfoServiceImpl(
			ShareInfoRepository shareInfoRepository) {
		this.shareInfoRepository = shareInfoRepository;
	}

	@Override
	public List<ShareInfo> findAll(ShareInfoRequest request) {
		if(request != null) {
			if( request.getUserSeq() != 0) {
				return shareInfoRepository.findByUserSeq(request.getUserSeq());
			}
		}
		
		return shareInfoRepository.findAll();
	}

	@Override
	public int save(ShareInfoRequest request) {
		User user = em.getReference(User.class, request.getUserSeq());
		BookInfo bookInfo = em.getReference(BookInfo.class, request.getBookSeq());
		
		ShareInfo shareInfo = ShareInfo.builder()
								.title(request.getTitle())
								.content(request.getContent())
								.price(request.getPrice())
								.user(user)
								.bookInfo(bookInfo)
								.build();
		em.persist(shareInfo);
		
		return shareInfo.getSeq();
	}

	@Override
	public ShareInfo findById(int seq) {
		return shareInfoRepository.findById(seq).get();
	}
}