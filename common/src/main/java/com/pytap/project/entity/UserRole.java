package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色
 * @author Ecin520
 * @date 2020/3/30 22:53
 */
@Getter @Setter
public class UserRole implements Serializable {

	private static final long serialVersionUID = 9023657752690029910L;

	private Long id;
	private Long userId;
	private Long roleId;
	private Date createTime;

	@Override
	public String toString() {
		return "UserRole{" +
				"id=" + id +
				", userId=" + userId +
				", roleId=" + roleId +
				", createTime=" + createTime +
				'}';
	}
}
