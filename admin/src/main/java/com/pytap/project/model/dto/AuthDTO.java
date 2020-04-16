package com.pytap.project.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限传输对象
 * @author Ecin520
 * @date 2020/3/26 23:12
 */
@Getter @Setter @ToString
public class AuthDTO implements Serializable {

    private static final long serialVersionUID = 406585186962456635L;

    private Long id;

    private String name;

    private String description;

    private Date createTime;

}
