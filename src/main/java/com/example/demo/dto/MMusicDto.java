package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MMusicDto {

	Integer getMusicId();
	String getMusicCd();
	String getMusicName();
	String getRecv_user_id_1();
	String getUserName();
	BigDecimal getRecv_percent_1();
	LocalDate getinsertDate();
	LocalDate getupdateDate();

}
