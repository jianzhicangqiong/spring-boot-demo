package com.example.data.cache;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.example.data.cache.service.UserService;
import com.example.data.cache.vo.UserVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
public class AppTest {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, UserVO> redisTemplate;


    @Test
    public void testCache() {

        // 新增用户
        userService.save(UserVO.create(1L));

        // 先查询用户
        UserVO dbUser = userService.getById(1L);
        log.info("查询到用户：{}", JSON.toJSONString(dbUser, JSONWriter.Feature.PrettyFormat));

        dbUser.setUsername("Mr.zhou");
        dbUser.setAge(25);
        // 修改
        userService.updateById(dbUser);

        // 查询
        UserVO dbUser1 = userService.getById(1L);
        log.info("修改之后的用户为：{}", JSON.toJSONString(dbUser1));

        // 删除
        // userService.deleteById(1L);

    }


    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set(String.valueOf(1), UserVO.create(1L));
        UserVO userVO = redisTemplate.opsForValue().get(String.valueOf(1));
        log.info(JSON.toJSONString(userVO, JSONWriter.Feature.PrettyFormat));
    }

}
