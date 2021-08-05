package kr.stam.app.share_info.service;

import java.util.List;

import kr.stam.app.dto.ShareInfoRequest;
import kr.stam.app.entity.ShareInfo;

public interface ShareInfoService {
	List<ShareInfo> findAll(ShareInfoRequest request);
	int save(ShareInfoRequest request);
	ShareInfo findById(int seq);
}