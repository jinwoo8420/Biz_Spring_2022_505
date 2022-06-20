package com.callor.images.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.service.FileUpService;

@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 implements FileUpService {

	private final String upLoadFolder;

	// servlet-context.xml에 bean으로 설정 된 값을 가져와서 upLoadFolder 변수에 담기
	public FileServiceImplV2(String upLoadFolder) {
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		if (file == null) {
			return null;
		}

		File dir = new File(upLoadFolder);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		String fileName = file.getOriginalFilename();

		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);

		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		return null;
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		return false;
	}

}
