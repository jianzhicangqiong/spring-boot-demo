package com.example.controller;


import com.alibaba.fastjson2.JSONObject;
import com.example.vo.Resp;
import com.example.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Tag(name = "UserController", description = "用户管理接口")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "查询用户", description = "通过条件查询用户列表")
    @GetMapping
    public Resp getUserList() {
        return Resp.ok(UserVO.create());
    }

    @Operation(summary = "获得用户", description = "通过用户id获得用户对象")
    @Parameters({@Parameter(name = "id", description = "用户id", required = true)})
    @GetMapping("/{id}")
    public Resp getUser(@PathVariable Long id) {
        Optional<UserVO> optional = UserVO.list().stream().filter(item -> Objects.equals(item.getId(), id)).findFirst();
        if (optional.isPresent()) {
            log.info("返回用户id为：{}", id);
            return Resp.ok(optional.get());
        }
        log.info("无此用户！");
        return Resp.error(2, "无此用户");
    }

    @Operation(summary = "新增用户", description = "创建一个新用户")
    @PostMapping
    public Resp saveUser(@RequestBody UserVO userVO) {
        log.info(JSONObject.toJSONString(userVO.toString()));
        return Resp.ok(userVO);
    }

    @Operation(summary = "删除用户", description = "根据用户id删除用户")
    @DeleteMapping("/{id}")
    public Resp deleteUserById(@PathVariable Long id) {
        log.info("{}", id);
        return Resp.ok();
    }

    @Operation(summary = "删除用户", description = "批量删除用户")
    @DeleteMapping
    public Resp deleteUserList(List<Long> ids) {
        log.info(JSONObject.toJSONString(ids));
        return Resp.ok();
    }


}
