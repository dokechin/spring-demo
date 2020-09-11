package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

//DB操作用のリポジトリクラス
public interface  MUserRepository extends JpaRepository<MUser, Integer>{
	// 命名規約に乗っ取った名前で定義すれば、実装しなくても使用できる
	MUser findByUserCd(String userCd);
}
