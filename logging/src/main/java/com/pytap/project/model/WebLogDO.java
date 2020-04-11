package com.pytap.project.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Ecin520
 * @date 2020/4/7 2:17
 */
@Getter @Setter
public class WebLogDO implements Serializable {

	private static final long serialVersionUID = 2618996880016222510L;

	private Integer id;
	private String description;
	private String username;
	private Long spendTime;
	private Long createTime;
	private String url;
	private String ip;

	@Override
	public String toString() {
		return "WebLogDO{" +
				"id=" + id +
				", description='" + description + '\'' +
				", username='" + username + '\'' +
				", spendTime=" + spendTime +
				", createTime=" + createTime +
				", url='" + url + '\'' +
				", ip='" + ip + '\'' +
				'}';
	}

}
