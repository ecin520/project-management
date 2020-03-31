package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户实体
 * @author Ecin520
 * @date 2020/3/26 21:42
 */
@Getter @Setter
public class User implements Serializable {

    private static final long serialVersionUID = 8712398133699802569L;

    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String nickname;
    private String note;
    private Date createTime;
    private Date loginTime;
    private Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(email, user.email) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(note, user.note) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(loginTime, user.loginTime) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, avatar, email, nickname, note, createTime, loginTime, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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
