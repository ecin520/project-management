package com.pytap.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Ecin520
 * @date 2020/4/7 2:17
 */
@Getter @Setter @ToString
public class WebLogDTO implements Serializable {

	private static final long serialVersionUID = 2618996880016222510L;

	private Long id;
	private String message;
	private String username;
	private String param;
	private String url;
	private String method;
	private Long spendTime;
	private String ip;
	private String result;
	private String createTime;

}
