package com.lemon.silence.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Data
public class UserInfo implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String userName;

	private String userAge;

	private String userSex;

	private String userClass;

	private String userDesc;

	private String createUser;

	private LocalDateTime createTime;

	private String updateUser;

	private LocalDateTime updateTime;

}