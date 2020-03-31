package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 角色对象
 * @author Ecin520
 * @date 2020/3/25 2:05
 */
@Getter @Setter
public class Role implements Serializable {

    private static final long serialVersionUID = 2364765432518210174L;

    private Long id;
    private String name;
    private String description;
    private Date createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role roleDO = (Role) o;
        return Objects.equals(id, roleDO.id) &&
                Objects.equals(name, roleDO.name) &&
                Objects.equals(description, roleDO.description) &&
                Objects.equals(createTime, roleDO.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime);
    }

    @Override
    public String toString() {
        return "RoleDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
