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

			MUser user2 = new MUser("2", "ダミーさん1","2",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user2);

			MUser user3 = new MUser("3", "ダミーさん2","3",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user3);

			MUser user4 = new MUser("4", "ダミーさん3","4",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user4);

			MUser user5 = new MUser("5", "ダミーさん4","5",LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mUserService.save(user5);

			MUser user6 = new MUser("6", "倉橋ヨエコ","6",LocalDate.of(2005, 3, 6), LocalDate.of(2005, 2, 8));
			mUserService.save(user6);


			MMusic music = new MMusic("1", "川の流れのように",
					"1",new BigDecimal(20),
					"2",new BigDecimal(20),
					"3",new BigDecimal(20),
					"4",new BigDecimal(20),
					"5",new BigDecimal(20),
					LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			mMusicService.save(music);

			MMusic music2 = new MMusic("2", "楯",
					"6",new BigDecimal(30),
					null,null,
					null,null,
					null,null,
					null,null,
					LocalDate.of(2005, 3, 6), LocalDate.of(2005, 2, 8));
			mMusicService.save(music2);

			TUseResult newTUseResult = new TUseResult(new Integer(1), user,
					music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "品川",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult);

			TUseResult newTUseResult2 = new TUseResult(new Integer(1), user2,
					music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "田町",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult2);

			TUseResult newTUseResult3 = new TUseResult(new Integer(1), user3,
					music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "五反田",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult3);

			TUseResult newTUseResult4 = new TUseResult(new Integer(1), user4,
					music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "中延",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult4);

			TUseResult newTUseResult5 = new TUseResult(new Integer(1), user2,
					music, new BigDecimal(123), LocalDate.of(1997, 1, 22), "大井町",  LocalDate.of(1997, 1, 23), LocalDate.of(1997, 1, 24));
			tUseResultService.save(newTUseResult5);

			TUseResult newTUseResult6 = new TUseResult(new Integer(1), user6,
					music, new BigDecimal(456), LocalDate.of(2005, 2, 8), "横浜",  LocalDate.of(2005, 3, 6), LocalDate.of(2005, 2, 8));
			tUseResultService.save(newTUseResult6);
		};
	}

}
