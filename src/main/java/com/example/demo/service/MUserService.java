package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MUser;
import com.example.demo.repository.MUserRepository;

// ビジネスロジッククラスのBeanであることを示すServiceアノテーションを付加する
@Service
public class MUserService {

    // MUser操作用のリポジトリをインジェクトする
	@Autowired
    private MUserRepository mUserRepository;

    public Iterable<MUser> findAll() {
    	return mUserRepository.findAll();
    }

    public MUser findById(Integer id) {
    	return mUserRepository.findById(id).get();
    }

    public MUser findByUserCd(String cd) {
    	return mUserRepository.findByUserCd(cd);
    }

    public void save(MUser mUser) {
    	mUserRepository.save(mUser);

    }
}
