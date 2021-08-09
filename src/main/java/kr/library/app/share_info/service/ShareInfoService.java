package kr.library.app.share_info.service;

import java.util.List;

import kr.library.app.dto.ShareInfoRequest;
import kr.library.app.entity.ShareInfo;

public interface ShareInfoService {
	List<ShareInfo> findAll(ShareInfoRequest request);
	int save(ShareInfoRequest request);
	ShareInfo findById(int seq);
}