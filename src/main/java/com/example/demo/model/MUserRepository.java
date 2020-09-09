package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  MUserRepository extends JpaRepository<MUser, Integer>{
	MUser findByUserCd(String userCd);
}
