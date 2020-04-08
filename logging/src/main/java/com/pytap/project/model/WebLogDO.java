package com.pytap.project.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/7 2:17
 */
@Getter @Setter
public class WebLogDO implements Serializable {

	private static final long serialVersionUID = 2618996880016222510L;

	private Integer id;
	private String type;
	private String ip;
	private String value;
	private Date createTime;

	@Override
	public String toString() {
		return "WebLogDO{" +
				"id=" + id +
				", type='" + type + '\'' +
				", ip='" + ip + '\'' +
				", value='" + value + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
