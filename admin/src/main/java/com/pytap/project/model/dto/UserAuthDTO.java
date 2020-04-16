package com.pytap.project.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户传输对象
 * @author Ecin520
 * @date 2020/3/23 21:31
 */
@Getter @Setter @ToString
public class UserAuthDTO implements Serializable {

    private static final long serialVersionUID = 4877789057808254537L;

    private Long id;
    private String username;
    private String avatar;
    private String email;
    private String nickname;
    private String note;
    private Date createTime;
    private Date loginTime;
    private Integer status;
    private List<AuthDTO> permission;

}
