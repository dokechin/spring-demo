package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * DBのcustomerテーブルに対応したエンティティクラス
 */
@Entity
public class TUseResult {

// 主キーであることを示すアノテーション
// 主キーの自動生成用のアノテーション
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer useResultId;

// リレーション定義のアノテーション
@OneToOne
    private MUser user;

//リレーション定義のアノテーション
@OneToOne
    private MMusic music;

    private BigDecimal amount;

    private LocalDate useDate;

    private String usePlace;

    private LocalDate insertDate;

    private LocalDate updateDate;

    public TUseResult() {}

    public TUseResult(Integer useResultId, MUser user, MMusic music, BigDecimal amount, LocalDate useDate, String usePlace,
			LocalDate insertDate, LocalDate updateDate) {
		this.useResultId = useResultId;
		this.user = user;
		this.music = music;
		this.amount = amount;
		this.useDate = useDate;
		this.usePlace = usePlace;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}

    public TUseResult(MUser user, MMusic music, BigDecimal amount, LocalDate useDate, String usePlace,
			LocalDate insertDate, LocalDate updateDate) {
    	this(null, user,music,amount, useDate,usePlace,insertDate, updateDate);
	}

    public Integer getUseResultId() {
		return useResultId;
	}

	public void setUseResultId(Integer useResultId) {
		this.useResultId = useResultId;
	}

	public MUser getUser() {
		return user;
	}

	public void setUser(MUser user) {
		this.user = user;
	}

	public MMusic getMusic() {
		return music;
	}

	public void setMusicCd(MMusic music) {
		this.music = music;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getUseDate() {
		return useDate;
	}

	public void setUseDate(LocalDate useDate) {
		this.useDate = useDate;
	}

	public String getUsePlace() {
		return usePlace;
	}

	public void setUsePlace(String usePlace) {
		this.usePlace = usePlace;
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
        return "TUseResult{" +
                "useResultId=" + useResultId +
                ", userCd='" + user.getUserCd() + '\'' +
                ", musicCd='" + music.getMusicCd() + '\'' +
                '}';
    }
}
