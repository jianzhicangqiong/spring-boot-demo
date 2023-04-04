package com.example.data.jpa.vo;

import jakarta.persistence.*;
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
@Entity     //标注为JPA实体类
@Table(name = "user")   //数据库表名称
public class UserVO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
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
