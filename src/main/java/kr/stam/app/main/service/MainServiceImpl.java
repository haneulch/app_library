package kr.stam.app.main.service;

import org.springframework.stereotype.Service;

import kr.stam.app.dto.FileTestRequest;
import kr.stam.app.entity.FileTest;
import kr.stam.core.util.FileUploadUtils;

@Service
public class MainServiceImpl implements MainService {

	MainRepository mainRepository;

	MainServiceImpl(MainRepository mainRepository) {
		this.mainRepository = mainRepository;
	}

	@Override
	public void save(FileTestRequest fileTestRequest) {

		FileTest fileTest = FileUploadUtils.uploadFile(fileTestRequest.getFile());
		mainRepository.save(fileTest);
	}
}
