package com.dam.tsk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dam.tsk.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
