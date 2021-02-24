package com.lemon.silence.controller;

import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.common.dto.ResponseMessageUntils;
import com.lemon.silence.service.LoginVerifyService;
import com.lemon.silence.utils.bo.GraphicBean;
import com.lemon.silence.utils.encryption.ShortUrlGenerator;
import com.lemon.silence.utils.encryption.VerifyGraphicUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "安全验证接口")
@RequestMapping(path = "/lemon/verity")
public class VerityController {

	@Autowired
	private LoginVerifyService loginVerifyService;

	@ApiOperation(value = "生成随机验证码图像", notes = "生成随机验证码图像")
	@GetMapping("/getGraphicImage")
	public void getGraphicImage(HttpServletResponse response) throws Exception{
		Map<String, Object> map = VerifyGraphicUtil.createImage();
		//将图片输出给浏览器
		BufferedImage image = (BufferedImage) map.get("image");
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	@ApiOperation(value = "生成随机验证码加密串", notes = "生成随机验证码加密串")
	@PostMapping("/getGraphicCode")
	public ResponseMessageEntity<GraphicBean> getGraphicCode(){
		return ResponseMessageUntils.successs(loginVerifyService.getGraphicCode());
	}

	@ApiOperation(value = "验证随机验证码", notes = "验证随机验证码")
	@GetMapping("/verifyGraphicCode")
	public ResponseMessageEntity<Boolean> verifyGraphicCode(GraphicBean graphicBean){
		if (!loginVerifyService.verityGraphicCode(graphicBean)){
			return ResponseMessageUntils.fail();
		}
		return ResponseMessageUntils.successs();
	}


	@ApiOperation(value = "生成短链接", notes = "长链接转成短链接")
	@GetMapping("/shortURL")
	public ResponseMessageEntity<String[]> getShortUrl(String longURL){
		ResponseMessageEntity<String[]> response = new ResponseMessageEntity<>();
		response.setData(ShortUrlGenerator.shortUrl(longURL));
		return response;
	}

}
