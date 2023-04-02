package com.example.jpa.service;

import com.example.jpa.dao.UserRepository;
import com.example.jpa.vo.UserVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<UserVO> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean insertUser(UserVO userVO) {
        UserVO save = userRepository.save(userVO);
        return !ObjectUtils.isEmpty(save);
    }

    @Override
    public boolean insertUserList(List<UserVO> userList) {
        return !CollectionUtils.isEmpty(userRepository.saveAll(userList));
    }

    @Override
    public UserVO findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserVO> findByAge(Integer age) {
        return userRepository.findByAge(age);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserVO> findByCondition(UserVO userVO) {
        return userRepository.findByUsernameAndAge(userVO.getUsername(), userVO.getAge());
    }
}
