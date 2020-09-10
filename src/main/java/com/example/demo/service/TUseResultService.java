package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.TUseResultForm;
import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.TUseResult;
import com.example.demo.model.TUseResultRepository;

// TODO 2-02 ビジネスロジッククラスのBeanであることを示すアノテーションを付加する
@Service
public class TUseResultService {

    // TODO 2-03 CustomerRepositoryをコンストラクタインジェクションする
	@Autowired
    private TUseResultRepository tUseResultRepository;

	@Autowired
	private MUserService mUserService;

	@Autowired
	private MMusicService mMusicService;

    public Iterable<TUseResult> findAll() {
    	return tUseResultRepository.findAll();
    }

    public TUseResult findById(Integer id) {
    	return tUseResultRepository.findById(id).get();
    }

    public void save(TUseResult tUseResult) {
    	tUseResultRepository.save(tUseResult);
    }

	public TUseResult convertToEntity(TUseResultForm form) {
		MUser user = mUserService.findByUserCd(form.getUserCd());
		MMusic music = mMusicService.findByMusicCd(form.getMusicCd());
		if (form.getId() == null) {
			return new TUseResult(user,music,form.getAmount(),form.getUseDate(),form.getUsePlace(),LocalDate.now(),null);
		} else {
			return new TUseResult(form.getId(), user, music,form.getAmount(),form.getUseDate(),form.getUsePlace(),LocalDate.now(),null);
		}
	}
}
