package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * DBのMMusicテーブルとMUserから楽曲一覧表示に必要なフィールドを持つエンティティクラス
 */
@Entity
public class Index {

	// 主キーであることを示すアノテーション
	// 主キーの自動生成用のアノテーション
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer useResultId;

	private String musicCd;

	private String musicName;

	private String recv_user_id_1;

	private String userName;

	private BigDecimal recv_percent_1;

	private LocalDate insertDate;

	private LocalDate updateDate;

	public Index() {}

	public Index(Integer useResultId, String musicCd, String musicName, String recv_user_id_1,String userName, BigDecimal recv_percent_1,
			LocalDate insertDate, LocalDate updateDate) {
		this.useResultId = useResultId;
		this.musicCd = musicCd;
		this.musicName = musicName;
		this.recv_user_id_1 = recv_user_id_1;
		this.userName = userName;
		this.recv_percent_1 = recv_percent_1;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}
	//引数が異なる多重ロード、オーバーロード
	public Index(String musicCd, String musicName, String recv_user_id_1, BigDecimal recv_percent_1,
			LocalDate insertDate, LocalDate updateDate) {
		this.musicCd = musicCd;
		this.musicName = musicName;
		this.recv_user_id_1 = recv_user_id_1;
		this.recv_percent_1 = recv_percent_1;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

	public Integer getUseResultId() {
		return useResultId;
	}

	public void setUseResultId(Integer useResultId) {
		this.useResultId = useResultId;
	}

	public String getMusicCd() {
		return musicCd;
	}

	public void setMusicCd(String musicCd) {
		this.musicCd = musicCd;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getRecv_user_id_1() {
		return recv_user_id_1;
	}

	public void setRecv_user_id_1(String recv_user_id_1) {
		this.recv_user_id_1 = recv_user_id_1;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getRecv_percent_1() {
		return recv_percent_1;
	}

	public void setRecv_percent_1(BigDecimal recv_percent_1) {
		this.recv_percent_1 = recv_percent_1;
	}

	public LocalDate getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDate insertDate) {
		this.insertDate = insertDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Index{" +
				"useResultId=" + useResultId +
				", musicName='" + musicName  + "musicCd=" + musicCd + '\'' +
				'}';
	}
}
