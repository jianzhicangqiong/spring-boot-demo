package com.example.data.cache.service;

import com.example.data.cache.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save(UserVO userVO) {
        log.info("保存至数据库");
        // log.info("保存用户：{}", JSON.toJSONString(userVO, JSONWriter.Feature.PrettyFormat));
    }

    @Override
    public void deleteById(Long id) {
        log.info("从数据库中删除用户");
        // log.info("删除用户：{}", id);
    }

    @Override
    public void updateById(UserVO userVO) {
        log.info("更新数据中用户");
        // log.info("更新用户：{}", JSON.toJSONString(userVO));
    }

    @Override
    public UserVO getById(Long id) {
        UserVO userVO = UserVO.create(1L);
        // log.info("获得用户为：{}", JSON.toJSONString(userVO, JSONWriter.Feature.PrettyFormat));
        log.info("从数据库中获得用户");
        return userVO;
    }
}
