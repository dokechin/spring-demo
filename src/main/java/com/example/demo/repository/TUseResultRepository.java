package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TUseResult;

//DB操作用のリポジトリクラス
public interface  TUseResultRepository extends JpaRepository<TUseResult, Integer>{
}
