package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Index;
import com.example.demo.model.IndexRepository;

// ビジネスロジッククラスのBeanであることを示すServiceアノテーションを付加する
@Service
public class IndexService {

 // Index操作用のリポジトリをインジェクトする
 	@Autowired
     private IndexRepository indexRepository;

     public Iterable<Index> findAll() {
     	return indexRepository.findAll();
     }
}
