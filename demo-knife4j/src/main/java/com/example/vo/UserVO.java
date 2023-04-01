package com.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@Schema(description = "用户信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "用户年龄")
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
