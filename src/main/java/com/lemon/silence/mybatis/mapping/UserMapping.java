package com.lemon.silence.mybatis.mapping;

import com.lemon.silence.mybatis.dto.UserInfoResponse;
import com.lemon.silence.mybatis.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapping {
    /**
     * 深复制转换
     * @param userInfo
     * @return UserInfoResponse
     */
    UserInfoResponse userInfoToUserInfoResponse(UserInfo userInfo);

    /**
     * 深复制转换
     * @param userInfoList
     * @return UserInfoResponse
     */
    List<UserInfoResponse> userInfoToUserInfoResponse(List<UserInfo> userInfoList);
}
