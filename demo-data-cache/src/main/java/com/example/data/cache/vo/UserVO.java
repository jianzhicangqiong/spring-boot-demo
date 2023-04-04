package com.example.data.cache.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private Long id;

    private String username;

    private int age;


    public static UserVO create() {
        long id = new Random().nextLong(30);
        return UserVO.builder().id(id).username("user-" + id).age((int) id).build();
    }

    public static UserVO create(long id) {
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
