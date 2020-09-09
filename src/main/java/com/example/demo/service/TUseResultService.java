package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TUseResult;
import com.example.demo.model.TUseResultRepository;

// TODO 2-02 ビジネスロジッククラスのBeanであることを示すアノテーションを付加する
@Service
public class TUseResultService {

    // TODO 2-03 CustomerRepositoryをコンストラクタインジェクションする
	@Autowired
    private TUseResultRepository tUseResultRepository;


    public Iterable<TUseResult> findAll() {
    	return tUseResultRepository.findAll();
    }

    public TUseResult findById(Integer id) {
    	return tUseResultRepository.findById(id).get();
    }

    public void save(TUseResult tUseResult) {
    	tUseResultRepository.save(tUseResult);

    }
}
