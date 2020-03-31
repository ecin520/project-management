package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户额外权限
 * @author Ecin520
 * @date 2020/3/30 22:54
 */
@Getter @Setter
public class UserAddPermission implements Serializable {

	private static final long serialVersionUID = 4293179380377503034L;

	private Long id;
	private Long userId;
	private Long additionalPermissionId;
	private Date createTime;

	@Override
	public String toString() {
		return "UserAddPermission{" +
				"id=" + id +
				", userId=" + userId +
				", additionalPermissionId=" + additionalPermissionId +
				", createTime=" + createTime +
				'}';
	}

}
