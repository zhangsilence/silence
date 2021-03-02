package com.lemon.silence.utils.encryption;

import com.lemon.silence.utils.bo.GraphicBean;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 图形验证码生成工具类
 *
 * @author zhangxueqi
 * @version 1.0
 */
public class VerifyGraphicUtil {
	/**验证码字符集*/
	private static final char[] CHARS = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	/**字符数量*/
	private static final int SIZE = 6;
	/**干扰线数量*/
	private static final int LINES = 8;
	/**宽度*/
	private static final int WIDTH = 120;
	/**高度*/
	private static final int HEIGHT = 30;
	/**字体大小*/
	private static final int FONT_SIZE = 30;

	private static Map<String,String> keyMap = new HashMap<>();
	/**
	 * 生成随机验证码及图片
	 */
	public static Map<String, Object> createImage() {
		StringBuffer sb = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.LIGHT_GRAY);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE; i++) {
			// 取随机字符索引
			int n = ran.nextInt(CHARS.length);
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 设置字体大小
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			// 画字符
			graphic.drawString(CHARS[n] + "", i * WIDTH / SIZE, HEIGHT * 2 / 3);
			// 记录字符
			sb.append(CHARS[n]);
		}
		// 6.画干扰线
		for (int i = 0; i < LINES; i++) {
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7.返回验证码和图片
		Map<String, Object> map = new HashMap<>(8);
		//验证码
		map.put("code", sb.toString());
		//图片
		map.put("image", image);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		map.put("uuid", uuid);
		keyMap.put("uuid", uuid);
		return map;
	}

	/**
	 * 随机取色
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		return new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
	}

	public static boolean verityGraphicCode(GraphicBean graphicBean){
		boolean result = false;
		if (keyMap.isEmpty()){
			return result;
		}
		String graphicKey = keyMap.get(graphicBean.getUuid()).toLowerCase();
		String graphicRequest = graphicBean.getGraphicCode().toLowerCase();
		result = graphicRequest.equals(graphicKey);
		if (result){
			keyMap.remove(graphicBean.getUuid());
		}
		return result;
	}
}