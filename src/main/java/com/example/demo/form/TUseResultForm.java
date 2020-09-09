package com.example.demo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.TUseResult;
import com.example.demo.service.MMusicService;
import com.example.demo.service.MUserService;

public class TUseResultForm {

	@Autowired
	private MUserService mUserService;

	@Autowired
	private MMusicService mMusicService;

    private Integer id;
    // TODO 3-01 検証アノテーションを付加する（空白不可、長さ1から32まで）
    @NotBlank
    @Length(min = 1, max = 3)
    private String userCd;

    // TODO 3-02 検証アノテーションを確認する（変更不要）
    @NotBlank
    @Length(min = 1, max = 3)
    private String musicCd;

    private BigDecimal amount;

    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate useDate;

    @Length(min = 1, max = 20)
    private String usePlace;

    public TUseResultForm(Integer id, String userCd,String musicCd, BigDecimal amount,
			LocalDate useDate, String usePlace) {
		super();
		this.id = id;
		this.userCd = userCd;
		this.musicCd = musicCd;
		this.amount = amount;
		this.useDate = useDate;
		this.usePlace = usePlace;
	}

    /**
     * フィールドがすべて空（null）のCustomerFormインスタンスを生成するメソッド
     */
    public static TUseResultForm createEmptyForm() {
        return new TUseResultForm(null, null, null, null, null, null);
    }

	public static TUseResultForm createForm(TUseResult src) {
    	return new TUseResultForm(src.getUseResultId(),
    			src.getUser().getUserCd(),
    			src.getMusic().getMusicCd(),
    			src.getAmount(),
    			src.getUseDate(),
    			src.getUsePlace());
    }

	public TUseResult convertToEntity() {
		MUser user = mUserService.findByUserCd(getUserCd());
		MMusic music = mMusicService.findByMusicCd(getMusicCd());
		return new TUseResult(user,music,getAmount(),getUseDate(),getUsePlace(),LocalDate.now(),null);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCd() {
		return userCd;
	}

	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}

	public String getMusicCd() {
		return musicCd;
	}

	public void setMusicCd(String musicCd) {
		this.musicCd = musicCd;
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
	public String toString() {
		return "userCd" + getUserCd() + "musicCd" + getMusicCd() + "amount" + getAmount();
	}

}
