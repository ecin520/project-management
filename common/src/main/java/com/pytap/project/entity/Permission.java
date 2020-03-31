package com.pytap.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 权限对象
 * @author Ecin520
 * @date 2020/3/23 22:15
 */
@Getter @Setter
public class Permission implements Serializable {

    private static final long serialVersionUID = -1806486557689825048L;

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
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime);
    }

    @Override
    public String toString() {
        return "PermissionDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
