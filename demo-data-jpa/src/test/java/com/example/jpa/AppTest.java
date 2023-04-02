package com.example.jpa;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.example.jpa.service.UserService;
import com.example.jpa.vo.UserVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Slf4j
@SpringBootTest
public class AppTest {

    @Resource
    private UserService userService;

    /**
     * 测试添加用户
     */
    @Test
    public void testSaveUser() {
        UserVO userVO = UserVO.create();
        boolean b = userService.insertUser(userVO);
        log.info("添加用户：{}", b);
    }

    @Test
    public void testSaveUserList() {
        List<UserVO> list = UserVO.list();
        boolean b = userService.insertUserList(list);
        log.info("添加用户：{}", b);
    }

    /**
     * 通过id查找用户
     */
    @Test
    public void findById() {
        UserVO userVO = userService.findById(new Random().nextLong(30));
        log.info(JSON.toJSONString(userVO, JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void test() {
        // 查找
        List<UserVO> allUsers = userService.findAllUsers();
        log.info("所有用户为：{}", JSON.toJSONString(allUsers, JSONWriter.Feature.PrettyFormat));

        List<UserVO> byAge = userService.findByAge(20);
        log.info("年龄为20的用户：{}", JSON.toJSONString(byAge, JSONWriter.Feature.PrettyFormat));

        List<UserVO> byCondition = userService.findByCondition(UserVO.builder().username("user-" + 5).age(5).build());
        log.info("年龄为5,username为user-5的用户：{}", JSON.toJSONString(byCondition, JSONWriter.Feature.PrettyFormat));

        userService.deleteById(4L);
        UserVO userVO = userService.findById(4L);
        log.info("id为4的用户是否存在：{}", !Objects.isNull(userVO));

    }


}
