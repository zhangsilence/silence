package com.lemon.silence.controller;

import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.utils.encryption.ShortUrlGenerator;
import com.lemon.silence.utils.encryption.VerifyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Map;

/**
 * 功能测试类提供接口调用
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/11/17 13:59
 */
@Slf4j
@RestController
@Api(tags = "样例")
@RequestMapping(path = "/lemon/api/demo")
public class DemoController {

	@ApiOperation(value = "生成随机验证码", notes = "生成随机验证码")
	@GetMapping("/verifyCode")
	public void getCode(HttpServletResponse response) throws Exception{
		Map<String, Object> map = VerifyUtil.createImage();
		//将图片输出给浏览器
		BufferedImage image = (BufferedImage) map.get("image");
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	@ApiOperation(value = "生成短链接", notes = "长链接转成短链接")
	@GetMapping("/shortURL")
	public ResponseMessageEntity<String[]> getShortUrl(String longURL){
		ResponseMessageEntity<String[]> response = new ResponseMessageEntity<>();
		response.setData(ShortUrlGenerator.shortUrl(longURL));
		return response;
	}

}
