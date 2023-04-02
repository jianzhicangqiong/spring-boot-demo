package com.example.jpa.dao;


import com.example.jpa.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// jpa应用，不用写简单的增删改查
public interface UserRepository extends JpaRepository<UserVO, Long> {

    List<UserVO> findByAge(Integer age);

    List<UserVO> findByUsernameAndAge(String username, int age);
}
