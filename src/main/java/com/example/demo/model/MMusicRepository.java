package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  MMusicRepository extends JpaRepository<MMusic, Integer>{
	MMusic findByMusicCd(String musicCd);
}
