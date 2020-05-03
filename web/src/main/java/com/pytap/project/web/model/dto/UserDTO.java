package com.pytap.project.web.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ecin520
 * @date 2020/4/29 13:50
 */
@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 6133777439057293379L;

	private Long id;
	private String username;
	private String avatar;
	private String email;
	private String nickname;
	private String note;
	private Date createTime;
	private Date loginTime;
	private Integer status;

}
