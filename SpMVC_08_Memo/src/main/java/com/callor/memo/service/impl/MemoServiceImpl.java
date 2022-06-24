package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoDao memoDao;

	private final ResourceLoader resLoader;

	private final String upLoadFolder;

	public MemoServiceImpl(ResourceLoader resLoader, String upLoadFolder) {
		this.resLoader = resLoader;
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public List<MemoVO> selectAll() {
		List<MemoVO> memo = memoDao.selectAll();
		return memo;
	}

	@Override
	public MemoVO findById(String id) {
		MemoVO memoVO = memoDao.findById(id);
		return memoVO;
	}

	@Override
	public int insert(MemoVO vo) {
		int ret = memoDao.insert(vo);
		return ret;
	}

	@Override
	public int update(MemoVO vo) {
		memoDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		memoDao.delete(id);
		return 0;
	}

	@Override
	public void create_memo_table() {
		memoDao.create_memo_table();
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
		String strUUID = UUID.randomUUID().toString();

		fileName = String.format("%s-%s", strUUID, fileName);

		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		return fileName;
	}

}
