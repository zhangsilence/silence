package com.lemon.silence.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.common.dto.ResponseMessageUntils;
import com.lemon.silence.common.exception.SentinelBlockExceptionHandler;
import com.lemon.silence.mybatis.entity.UserInfo;
import com.lemon.silence.mybatis.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 用户信息管理服务类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/15 13:53
 */
@Slf4j
@Service
public class UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional(rollbackFor = Exception.class)
	public ResponseMessageEntity getUserInfo() {
		List<UserInfo> userInfoList = userInfoMapper.selectAll();
		return ResponseMessageUntils.successs(userInfoList);
	}

	@SentinelResource(value = "getUserInfos", blockHandler = "sentinelExceptionHandler", blockHandlerClass = SentinelBlockExceptionHandler.class)
	public ResponseMessageEntity getUserInfoSentinel() {
		List<UserInfo> userInfoList = userInfoMapper.selectAll();
		return ResponseMessageUntils.successs(userInfoList);
	}

}
