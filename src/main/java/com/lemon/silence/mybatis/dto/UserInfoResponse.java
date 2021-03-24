package com.lemon.silence.mybatis.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author silence
 */
@Data
public class UserInfoResponse implements Serializable {

    private String userName;

    private String userDesc;
}
