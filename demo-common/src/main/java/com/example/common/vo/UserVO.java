package com.example.common.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@Data
@Builder
public class UserVO {

    private Long id;

    private String username;

    private int age;


    public static UserVO create() {
        long id = new Random().nextLong(30);
        return UserVO.builder().id(id).username("user-" + id).age((int) id).build();
    }

    public static List<UserVO> list() {
        List<UserVO> userVOList = new ArrayList<>();
        LongStream.range(0, 30).forEach(id -> {
            userVOList.add(UserVO.builder().id(id).username("user-" + id).age((int) id).build());
        });
        return userVOList;
    }
}
