package com.pytap.project.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/10 18:34
 */
@Getter @Setter
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -4130148137290050925L;

	private Long id;
	private String username;
	private String avatar;
	private String email;
	private String nickname;
	private String note;
	private Date createTime;
	private Date loginTime;
	private Integer status;

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", username='" + username + '\'' +
				", avatar='" + avatar + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", note='" + note + '\'' +
				", createTime=" + createTime +
				", loginTime=" + loginTime +
				", status=" + status +
				'}';
	}
}
