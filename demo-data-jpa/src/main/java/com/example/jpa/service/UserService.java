package com.example.jpa.service;

import com.example.jpa.vo.UserVO;

import java.util.List;

public interface UserService {

    // 查询所有
    List<UserVO> findAllUsers();

    // 新增
    boolean insertUser(UserVO userVO);

    boolean insertUserList(List<UserVO> userList);

    // 根据id查询
    UserVO findById(Long id);

    // 根据username查询
    List<UserVO> findByAge(Integer age);

    // 根据id删除
    void deleteById(Long id);

    // 根据条件查询
    List<UserVO> findByCondition(UserVO userVO);


}
