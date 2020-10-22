package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

// DB操作用のリポジトリクラス
public interface  MMusicRepository extends JpaRepository<MMusic, Integer>{
	// 命名規約に乗っ取った名前で定義すれば、実装しなくても使用できる
	MMusic findByMusicCd(String musicCd);
	static MMusic findByMusicName(String musicName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
