package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoDTO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService {

	protected final FileUpService fileup;
	protected final MemoDao memoDao;

	public MemoServiceImplV1(FileUpService fileup, MemoDao memoDao) {
		this.fileup = fileup;
		this.memoDao = memoDao;
	}

	@Autowired
	public void create_table() {
		memoDao.create_memo_table();
	}

	@Override
	public List<MemoDTO> selectAll() {
		return memoDao.selectAll();
//		return null;
	}

	@Override
	public int insertAndUpdate(MemoDTO memo, MultipartFile file) {
		/*
		 * insert가 되는 경우는 m_seq가 0일 것이고
		 * update가 되는 경우는 m_seq가 0이 아닐 것이다
		 */

		long m_seq = memo.getM_seq();

		// 메모 수정일 경우 처리
		if (m_seq != 0) {
			MemoDTO updateMemo = memoDao.findById(m_seq); // seq 값으로 table에서 데이터 가져오기
			String fileName = updateMemo.getM_image(); // 저장된 파일 이름 가져오기

			if (!fileName.equals(file.getOriginalFilename())) { // 저장된 파일 이름과 새롭게 업로드된 파일 이름이 다를 시
				fileup.fileDelete(updateMemo.getM_up_image());
			}

			String upLoadFileName = fileup.fileUp(file); // 파일 업로드하고 업로드된 파일 이름 가져오기

			// table에 저장하기 위해 원래 파일 이름과 UUID가 부착된 파일 이름을 DTO에 저장
			memo.setM_image(file.getOriginalFilename());
			memo.setM_up_image(upLoadFileName);

			return memoDao.update(memo);
		}

		memo.setM_image(file.getOriginalFilename());
		memo.setM_up_image(fileup.fileUp(file));

		return memoDao.insert(memo);
	}

	/*
	 * 메모 삭제
	 * 1. 첨부 파일이 있을 경우 파일을 먼저 삭제
	 * 2. 그 후 데이터 삭제
	 * 
	 * 만약 순서가 바뀔 시 필요없는 파일들이 폴더에 남아 있을 수 있다
	 */

	@Override
	public int delete(Long seq) {
		MemoDTO memo = memoDao.findById(seq); // seq에 해당하는 데이터 select

		fileup.fileDelete(memo.getM_up_image()); // 파일 이름을 fileDelete() method에 보낸 후 파일 삭제

		memoDao.delete(seq); // 데이터 삭제

		return 0;
	}

	@Override
	public MemoDTO findById(Long seq) {
		return memoDao.findById(seq);
	}

	@Override
	public List<MemoDTO> findByAuthor(String username) {
		return memoDao.findByAuthor(username);
	}

}
