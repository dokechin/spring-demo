package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.MMusicDto;
import com.example.demo.entity.MMusic;

// DB操作用のリポジトリクラス
public interface  MMusicRepository extends JpaRepository<MMusic, Integer>{
	// 命名規約に乗っ取った名前で定義すれば、実装しなくても使用できる
	MMusic findByMusicCd(String musicCd);
	static MMusic findByMusicName(String musicName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public static final String FIND_SOMETHING = "Select m.musicId as musicId,m.musicCd as musicCd,m.musicName as musicName,m.recv_user_id_1 as recv_user_id_1,u.userName as userName,"
	 		+ "m.recv_percent_1 as recv_percent_1,m.insertDate as insertDate,m.updateDate as updateDate " +
            "from MMusic m " +
            "inner join MUser u on m.recv_user_id_1 = u.userId";
	 @Query( value = FIND_SOMETHING)
	 List<MMusicDto> findMMusicAll();

}
