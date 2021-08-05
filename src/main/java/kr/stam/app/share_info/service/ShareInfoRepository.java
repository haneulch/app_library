package kr.stam.app.share_info.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.stam.app.entity.ShareInfo;

@Repository
public interface ShareInfoRepository extends JpaRepository<ShareInfo, Integer> {
	List<ShareInfo> findByUserSeq(int userSeq);
}
