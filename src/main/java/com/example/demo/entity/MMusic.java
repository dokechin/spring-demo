package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * DBのMMusicテーブルに対応したエンティティクラス
 */
@Entity
public class MMusic {

	// 主キーであることを示すアノテーション
	// 主キーの自動生成用のアノテーション
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer musicId;

	private String musicCd;

	private String musicName;

	private String recv_user_id_1 = " ";

	private BigDecimal recv_percent_1;

	private String recv_user_id_2 = " ";

	private BigDecimal recv_percent_2;

	private String recv_user_id_3 = " ";

	private BigDecimal recv_percent_3;

	private String recv_user_id_4 = " ";

	private BigDecimal recv_percent_4;

	private String recv_user_id_5 = " ";

	private BigDecimal recv_percent_5;

	private LocalDate insertDate;

	private LocalDate updateDate;

	public MMusic() {}

	public MMusic(Integer musicId, String musicCd, String musicName, String recv_user_id_1, BigDecimal recv_percent_1,
			String recv_user_id_2, BigDecimal recv_percent_2, String recv_user_id_3, BigDecimal recv_percent_3,
			String recv_user_id_4, BigDecimal recv_percent_4, String recv_user_id_5, BigDecimal recv_percent_5,
			LocalDate insertDate, LocalDate updateDate) {
		this.musicId = musicId;
		this.musicCd = musicCd;
		this.musicName = musicName;
		this.recv_user_id_1 = recv_user_id_1;
		this.recv_percent_1 = recv_percent_1;
		this.recv_user_id_2 = recv_user_id_2;
		this.recv_percent_2 = recv_percent_2;
		this.recv_user_id_3 = recv_user_id_3;
		this.recv_percent_3 = recv_percent_3;
		this.recv_user_id_4 = recv_user_id_4;
		this.recv_percent_4 = recv_percent_4;
		this.recv_user_id_5 = recv_user_id_5;
		this.recv_percent_5 = recv_percent_5;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

	public MMusic(String musicCd, String musicName, String recv_user_id_1, BigDecimal recv_percent_1,
			String recv_user_id_2, BigDecimal recv_percent_2, String recv_user_id_3, BigDecimal recv_percent_3,
			String recv_user_id_4, BigDecimal recv_percent_4, String recv_user_id_5, BigDecimal recv_percent_5,
			LocalDate insertDate, LocalDate updateDate) {
		this.musicCd = musicCd;
		this.musicName = musicName;
		this.recv_user_id_1 = recv_user_id_1;
		this.recv_percent_1 = recv_percent_1;
		this.recv_user_id_2 = recv_user_id_2;
		this.recv_percent_2 = recv_percent_2;
		this.recv_user_id_3 = recv_user_id_3;
		this.recv_percent_3 = recv_percent_3;
		this.recv_user_id_4 = recv_user_id_4;
		this.recv_percent_4 = recv_percent_4;
		this.recv_user_id_5 = recv_user_id_5;
		this.recv_percent_5 = recv_percent_5;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

	public Integer getMusicId() {
		return musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
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

	public BigDecimal getRecv_percent_1() {
		return recv_percent_1;
	}

	public void setRecv_percent_1(BigDecimal recv_percent_1) {
		this.recv_percent_1 = recv_percent_1;
	}

	public String getRecv_user_id_2() {
		return recv_user_id_2;
	}

	public void setRecv_user_id_2(String recv_user_id_2) {
		this.recv_user_id_2 = recv_user_id_2;
	}

	public BigDecimal getRecv_percent_2() {
		return recv_percent_2;
	}

	public void setRecv_percent_2(BigDecimal recv_percent_2) {
		this.recv_percent_2 = recv_percent_2;
	}

	public String getRecv_user_id_3() {
		return recv_user_id_3;
	}

	public void setRecv_user_id_3(String recv_user_id_3) {
		this.recv_user_id_3 = recv_user_id_3;
	}

	public BigDecimal getRecv_percent_3() {
		return recv_percent_3;
	}

	public void setRecv_percent_3(BigDecimal recv_percent_3) {
		this.recv_percent_3 = recv_percent_3;
	}

	public String getRecv_user_id_4() {
		return recv_user_id_4;
	}

	public void setRecv_user_id_4(String recv_user_id_4) {
		this.recv_user_id_4 = recv_user_id_4;
	}

	public BigDecimal getRecv_percent_4() {
		return recv_percent_4;
	}

	public void setRecv_percent_4(BigDecimal recv_percent_4) {
		this.recv_percent_4 = recv_percent_4;
	}

	public String getRecv_user_id_5() {
		return recv_user_id_5;
	}

	public void setRecv_user_id_5(String recv_user_id_5) {
		this.recv_user_id_5 = recv_user_id_5;
	}

	public BigDecimal getRecv_percent_5() {
		return recv_percent_5;
	}

	public void setRecv_percent_5(BigDecimal recv_percent_5) {
		this.recv_percent_5 = recv_percent_5;
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
		return "MMusic{" +
				"musicId=" + musicId +
				", musicName='" + musicName + '\'' + "recv_user_id_1=" + recv_user_id_1 +
				'}';
	}
}
