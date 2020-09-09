package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MMusic;
import com.example.demo.model.MMusicRepository;

// TODO 2-02 ビジネスロジッククラスのBeanであることを示すアノテーションを付加する
@Service
public class MMusicService {

    // TODO 2-03 CustomerRepositoryをコンストラクタインジェクションする
	@Autowired
    private MMusicRepository mMusicRepository;


    public Iterable<MMusic> findAll() {
    	return mMusicRepository.findAll();
    }

    public MMusic findById(Integer id) {
    	return mMusicRepository.findById(id).get();
    }
    public MMusic findByMusicCd(String musicCd) {
    	return mMusicRepository.findByMusicCd(musicCd);
    }

    public void save(MMusic mMusic) {
    	mMusicRepository.save(mMusic);

    }
}
