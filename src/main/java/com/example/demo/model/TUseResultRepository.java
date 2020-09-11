package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

//DB操作用のリポジトリクラス
public interface  TUseResultRepository extends JpaRepository<TUseResult, Integer>{
}
