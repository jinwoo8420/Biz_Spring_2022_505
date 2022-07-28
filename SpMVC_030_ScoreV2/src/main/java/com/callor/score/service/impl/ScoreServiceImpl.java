package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreUpdateVO;
import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreDao scDao;

	@Override
	public List<ScoreVO> findByStNum(String stnum) {
		return scDao.findByStNum(stnum);
	}

	@Override
	public List<ScoreVO> selectAll() {
		return scDao.selectAll();
	}

	@Override
	public ScoreVO findById(String id) {
		return scDao.findById(id);
	}

	@Override
	public int insert(ScoreVO vo) {
		scDao.insert(vo);
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		scDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		scDao.delete(id);
		return 0;
	}

	@Override
	public int updateScore(String st_num, String[] sb_code, String[] sc_score) {
		int ret = 0;

		for (int i = 0; i < sb_code.length; i++) {
			ret += scDao.updateScoreArray(st_num, sb_code[i], sc_score[i]);
		}

		return ret;
	}

	@Override
	public int updateScore(ScoreUpdateVO score) {
		return scDao.updateScore(score);
	}

	@Override
	public int updateScoreArray(String st_num, String sb_code, String sc_score) {
		return 0;
	}

}
