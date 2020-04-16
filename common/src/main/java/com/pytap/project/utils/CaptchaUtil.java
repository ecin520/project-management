package com.pytap.project.utils;

import com.pytap.project.pojo.CaptchaImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成器
 * @author Ecin520
 * @date 2020/4/11 10:05
 */
public class CaptchaUtil {

	/**
	 * 随机code集合
	 * */
	private static final String COLLECTION = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final int WIDTH = 85;
	private static final int HEIGHT = 25;

	/**
	 * 干扰线数量
	 * */
	private static final int LINE_NUM = 15;

	/**
	 * 验证码数量
	 * */
	private static final int CAPTCHA_NUM = 5;

	private final Random random = new Random();


	public CaptchaImage createRandCode() {
		CaptchaImage captchaImage = new CaptchaImage();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0 , WIDTH, HEIGHT);
		g.setFont(new Font("Times New Roman", Font.BOLD, 19));
		g.setColor(new Color(193, 193, 193));
		for (int i = 0; i < LINE_NUM; i++) {
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			g.drawLine(x, y, x + random.nextInt(13), y + random.nextInt(15));
		}
		String result = "";
		for (int i = 0; i < CAPTCHA_NUM; i++) {
			result = drawString(g, result, i);
		}
		captchaImage.setBufferedImage(image);
		captchaImage.setResult(result);
		g.dispose();
		return captchaImage;
	}

	private String drawString(Graphics g, String result, int i) {
		g.setFont(new Font("Times New Roman", Font.BOLD, 18));
		g.setColor(randomColor());
		String rand = String.valueOf(
				COLLECTION.charAt(random.nextInt(COLLECTION.length()))
		);
		result += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return result;
	}

	private Color randomColor() {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r, g, b);
	}

}
