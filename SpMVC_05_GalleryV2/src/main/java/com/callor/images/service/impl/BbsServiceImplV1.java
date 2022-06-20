package com.callor.images.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.BBsVO;
import com.callor.images.model.FilesVO;
import com.callor.images.persistance.BbsDao;
import com.callor.images.persistance.FileDao;
import com.callor.images.service.BBsService;
import com.callor.images.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.BBS_V1)
public class BbsServiceImplV1 implements BBsService {

	protected final BbsDao bbsDao;
	protected final FileUpService fileService;
	protected final FileDao fileDao;

	public BbsServiceImplV1(BbsDao bbsDao, @Qualifier(QualifierConfig.SERVICE.FILE_V2) FileUpService fileService,
			FileDao fileDao) {
		this.bbsDao = bbsDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@Override
	public String insertBbsAndFile(BBsVO bbsVO, MultipartFile file) {

		// 게시판 내용(text)을 먼저 insert 실행
		int ret = bbsDao.insert(bbsVO);

		/*
		 * 게시판 내용을 insert 하고 나면
		 * bbsVO.b_seq 값이 새로 생성된 상태가 된다
		 */

		log.debug("INSERT {}", ret);
		// 정상적으로 BBS 내용이 insert 되었으면
		if (ret > 0) {
			try {
				// 파일 업로드하기
				String fileName = fileService.fileUp(file);
				// 업로드 된 파일 정보로 imageVO 데이터 생성하기
				FilesVO imageVO = FilesVO.builder().i_originalName(file.getOriginalFilename()).i_imageName(fileName)
						.i_bseq(bbsVO.getB_seq()).build();
				// tbl_images에 추가하기
				fileDao.insert(imageVO);
				log.debug(imageVO.toString());
				return imageVO.getI_imageName();
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("FILE UP FAIL");
				return "FILE UP FAIL";
			}
		}

		return null;
	}

	@Override
	public String insertBbsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files) {
		int ret = bbsDao.insert(bbsVO);

		/*
		 * 실제 이미지 데이터들은 files에 담겨 있는데
		 * files에 담겨있는 개별적인 파일을 분리하여 List로 바꾸기 위해서
		 * files.getFiles() method를 사용하는데
		 * 이때 getFiles()에게 form의 input tag 이름을 전달해 주어야 한다
		 */
//		List<MultipartFile> fileList = files.getFiles("mFile");

//		for (MultipartFile file : fileList) {
//			log.debug("파일들 : {}", file.getOriginalFilename());
//		}

		try {
			List<FilesVO> fileNames = fileService.filesUp(files);

			for (FilesVO file : fileNames) {
				file.setI_seq(bbsVO.getB_seq());
			}

			ret = fileDao.insertFiles(fileNames);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void create_bbs_table() {
	}

	@Override
	public List<BBsVO> selectAll() {
		return null;
	}

	@Override
	public BBsVO findById(Long id) {
		return bbsDao.findById(id);
	}

	@Override
	public int insert(BBsVO vo) {
		return 0;
	}

	@Override
	public int update(BBsVO vo) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		return 0;
	}

}