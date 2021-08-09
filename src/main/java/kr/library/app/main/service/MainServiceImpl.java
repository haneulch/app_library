package kr.library.app.main.service;

import org.springframework.stereotype.Service;

import kr.library.app.dto.FileTestRequest;
import kr.library.app.entity.FileTest;
import kr.library.core.util.FileUploadUtils;

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
