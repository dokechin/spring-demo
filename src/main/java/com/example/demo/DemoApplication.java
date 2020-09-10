package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.MMusic;
import com.example.demo.model.MUser;
import com.example.demo.model.TUseResult;
import com.example.demo.service.MMusicService;
import com.example.demo.service.MUserService;
import com.example.demo.service.TUseResultService;

@SpringBootApplication
public class DemoApplication {

	// JPA
	// https://www.objectdb.com/java/jpa/entity/id

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			MUserService mUserService, MMusicService mMusicService, TUseResultService tUseResultService) {
		return (args) -> {

			MUser user = new MUser("1", "秋元康","1",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user);
			MMusic music = new MMusic("1", "川の流れのように",
					"1",new BigDecimal(1002),
					"2",new BigDecimal(102),
					"3",new BigDecimal(522),
					"4",new BigDecimal(632),
					"5",new BigDecimal(874),
					LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mMusicService.save(music);

			TUseResult newTUseResult = new TUseResult(new Integer(1), user,
	                music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "品川",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult);
		};
	}

}
