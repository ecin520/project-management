package com.pytap.project.pojo;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

/**
 * @author Ecin520
 * @date 2020/4/13 11:38
 */
@Getter @Setter
public class CaptchaImage {
	private BufferedImage bufferedImage;
	private String result;
}
