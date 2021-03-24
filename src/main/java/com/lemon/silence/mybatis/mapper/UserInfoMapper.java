package com.lemon.silence.mybatis.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.silence.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	List<UserInfo> selectAll();

	Page<UserInfo> selectUserInfo(@Param("pg") IPage<?> page);

	UserInfo selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);
}