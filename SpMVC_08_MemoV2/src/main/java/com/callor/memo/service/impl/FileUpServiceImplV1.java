package com.callor.memo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.service.FileUpService;

@Service
public class FileUpServiceImplV1 implements FileUpService {

	/*
	 * servlet-context.xml에 선언 된 문자열 변수 값 연결
	 */
	@Autowired
	protected String upLoadFolder;

	@Override
	public String fileUp(MultipartFile file) {
		if (file == null) { // 파일 정보가 없을 시 진행 X
			return null;
		}

		File dir = new File(upLoadFolder); // 저장 할 폴더 확인

		if (!dir.exists()) { // 업로드 폴더가 없을 시
			dir.mkdirs(); // 폴더 생성
		}

		String originFileName = file.getOriginalFilename(); // 업로드 된 파일의 이름 getter

		// 해킹 방지를 위해 파일 이름 암호화
		String uuStr = UUID.randomUUID().toString(); // 1. UUID 문자열 생성

		String saveFileName = String.format("%s-%s", uuStr, originFileName); // 2. 원래 파일 이름과 UUID를 합성하여 새로운 파일 이름 지정

		File saveFile = new File(upLoadFolder, saveFileName); // 서버에 저장하기 위한 파일 객체 생성

		try {
			file.transferTo(saveFile);
			return saveFileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) {
		return null;
	}

	@Override
	public void fileDelete(String fileName) {
		if (fileName == null) {
			return;
		}

		File deleteFile = new File(upLoadFolder, fileName); // 업로드 폴더와 파일 이름을 묶어서 파일 객체 생성

		if (deleteFile.exists()) { // 파일이 존재 할 때
			deleteFile.delete(); // 파일 삭제
		}

	}

}
