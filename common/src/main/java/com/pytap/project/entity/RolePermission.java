package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限
 * @author Ecin520
 * @date 2020/3/30 22:53
 */
@Getter @Setter
public class RolePermission implements Serializable {

	private static final long serialVersionUID = -8182491396162941319L;

	private Long id;
	private Long roleId;
	private Long permissionId;
	private Date createTime;

	@Override
	public String toString() {
		return "RolePermission{" +
				"id=" + id +
				", roleId=" + roleId +
				", permissionId=" + permissionId +
				", createTime=" + createTime +
				'}';
	}
}
