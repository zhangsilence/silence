package com.lemon.silence.controller;

import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.common.dto.ResponseMessageUntils;
import com.lemon.silence.service.RestfulCallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远端调用demo
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/8/28 14:04
 */
@Slf4j
@RestController
@Api(tags = "远端调用方式接口")
@RequestMapping(path = "/api/lemon/remote")
public class RestfulCallController {

	@Autowired
	private RestfulCallService restfulCallService;

	@ApiOperation(value = "获取用户信息", notes = "获取用户信息")
	@PostMapping("/restTemplate")
	public ResponseMessageEntity<String> getUserInfo() {
		log.info("获取用户信息成功");
		return ResponseMessageUntils.successs(restfulCallService.getContentInfo());
	}
}
