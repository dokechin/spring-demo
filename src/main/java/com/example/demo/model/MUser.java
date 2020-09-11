package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * DBのcustomerテーブルに対応したエンティティクラス
 */
@Entity
public class MUser {

// 主キーであることを示すアノテーション
// 主キーの自動生成用のアノテーション
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String userCd;

    private String userName;

    private String userKbn;

    private LocalDate insertDate;

    private LocalDate updateDate;

    public MUser() {}


    public MUser(Integer userId, String userCd, String userName, String userKbn, LocalDate insertDate, LocalDate updateDate) {
		this.userId = userId;
		this.userCd = userCd;
		this.userName = userName;
		this.userKbn = userKbn;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

    public MUser(String userCd, String userName, String userKbn, LocalDate insertDate, LocalDate updateDate) {
    	this(null, userCd,userName, userKbn, insertDate, updateDate);
	}

	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUserCd() {
		return userCd;
	}



	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserKbn() {
		return userKbn;
	}



	public void setUserKbn(String userKbn) {
		this.userKbn = userKbn;
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
        return "MUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
