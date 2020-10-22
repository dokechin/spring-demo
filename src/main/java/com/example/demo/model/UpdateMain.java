package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * DBのMMusicテーブルとMUserから楽曲データ更新表示に必要なフィールドを持つエンティティクラス
 */
@Entity
public class UpdateMain {

	// 主キーであることを示すアノテーション
	// 主キーの自動生成用のアノテーション
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	private String musicCd;

	// 検証アノテーション（空白不可、長さ1から40まで）
	@NotBlank
	@Length(min = 1, max = 40)
	private String musicName;

	// 検証アノテーション（空白不可、長さは3）
	@NotBlank
	@Length(min = 1, max = 3)
	private String recv_user_id_1;

	// 検証アノテーション（空白不可、長さは1から3）
	@NotNull
	@Min(1)
	@Max(999)
	private BigDecimal recv_percent_1;

	// 検証アノテーション（長さは3）
	@Length(min = 0, max = 3)
	private String recv_user_id_2;

	// 検証アノテーション（長さは1から3）
	@Min(0)
	@Max(999)
	private BigDecimal recv_percent_2;

	// 検証アノテーション（長さは3）
	@Length(min = 0, max = 3)
	private String recv_user_id_3;

	// 検証アノテーション（長さは1から3）
	@Min(0)
	@Max(999)
	private BigDecimal recv_percent_3;

	// 検証アノテーション（長さは3）
	@Length(min = 0, max = 3)
	private String recv_user_id_4;

	// 検証アノテーション（長さは1から3）
	@Min(0)
	@Max(999)
	private BigDecimal recv_percent_4;

	// 検証アノテーション（長さは3）
	@Length(min = 0, max = 3)
	private String recv_user_id_5;

	// 検証アノテーション（長さは1から3）
	@Min(0)
	@Max(999)
	private BigDecimal recv_percent_5;

	private LocalDate insertDate;

	private LocalDate updateDate;

	private String userName1 = " ";
	private String userName2 = " ";
	private String userName3 = " ";
	private String userName4 = " ";
	private String userName5 = " ";

	public Integer getId() {
		return Id;
	}

	public void setUseResultId(Integer Id) {
		this.Id = Id;
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

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

	public String getUserName3() {
		return userName3;
	}

	public void setUserName3(String userName3) {
		this.userName3 = userName3;
	}

	public String getUserName4() {
		return userName4;
	}

	public void setUserName4(String userName4) {
		this.userName4 = userName4;
	}

	public String getUserName5() {
		return userName5;
	}

	public void setUserName5(String userName5) {
		this.userName5 = userName5;
	}

	@Override
	public String toString() {
		return "UpdateMain{" +
				"Id=" + Id +
				", musicName='" + musicName  + "musicCd=" + musicCd + "userName1=" + userName1 + "userName2=" + userName2 + "userName3=" + userName3 + "userName4=" + userName4 + "userName5=" + userName5 + '\'' +
				'}';
	}
}
