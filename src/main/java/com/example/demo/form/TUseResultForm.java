package com.example.demo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.model.TUseResult;
public class TUseResultForm {

    private Integer id;

    // 検証アノテーション（空白不可、長さ1から3まで）
    @NotBlank
    @Length(min = 1, max = 3)
    private String userCd;

    // 検証アノテーション（空白不可、長さ1から3まで）
    @NotBlank
    @Length(min = 1, max = 3)
    private String musicCd;

    // 検証アノテーション（空白不可、1から99999）
    @NotNull
    @Min(1)
    @Max(99999)
    private BigDecimal amount;

    // 検証アノテーション（日付形式）
    @DateTimeFormat(pattern="uuuu/MM/dd")
    private LocalDate useDate;

    // 検証アノテーション（長さ20まで）
    @Length(min=0, max = 20)
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
     * フィールドがすべて空（null）のTUseResultFormインスタンスを生成するメソッド
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
