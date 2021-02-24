package com.lemon.silence.utils.Paging;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.silence.utils.Paging.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * 通用工具类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/10/17 14:38
 */
@Slf4j
@Component
public class CommonUtils {

	/**
	 * 获取分页信息
	 * @param page mybatis-plus分页信息
	 * @return 项目分页信息
	 */
	public static <T> Paging<T> getPaging(Page<?> page){
		Paging<T> paging = new Paging<>();
		paging.setPageNo(page.getCurrent());
		paging.setPageSize(page.getSize());
		paging.setTotal(page.getTotal());
		paging.setTotalPage(page.getPages());
		return paging;
	}

	/**
	 * 获取UUID
	 * @return UUID
	 */
	public static String uuid(){
		return UUID.randomUUID().toString();
	}

	/**
	 * 获取当前ip地址
	 * @return 默认返回127.0.0.1
	 */
	public static String getHostIP(){
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			return localHost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "127.0.0.1";
	}
}
