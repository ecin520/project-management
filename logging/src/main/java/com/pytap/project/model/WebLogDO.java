package com.pytap.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Ecin520
 * @date 2020/4/7 2:17
 */
@Getter @Setter @ToString
public class WebLogDO implements Serializable {

	private static final long serialVersionUID = 2618996880016222510L;

	private Integer id;
	private String description;
	private String username;
	private String method;
	private Long spendTime;
	private String ip;
	private String result;
	private String createTime;

}
