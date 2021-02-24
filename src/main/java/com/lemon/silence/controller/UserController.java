package com.lemon.silence.controller;

import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.mybatis.entity.UserInfo;
import com.lemon.silence.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理功能
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/9 16:31
 */
@Slf4j
@RestController
@Api(tags = "用户管理")
@RequestMapping(path = "/lemon/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取用户信息", notes = "获取用户信息")
	@GetMapping("/info")
	public ResponseMessageEntity<List<UserInfo>> getUserInfo() {
		log.info("获取用户信息成功");
		return userService.getUserInfo();
	}

	@ApiOperation(value = "获取用户信息-sentinel", notes = "获取用户信息-sentinel")
	@GetMapping("/info-sentinel")
	public ResponseMessageEntity<List<UserInfo>> getUserInfoSentinel() {
		log.info("获取用户信息成功-sentinel");
		return userService.getUserInfoSentinel();
	}

}
