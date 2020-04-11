package com.pytap.project.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 额外权限对象
 * @author Ecin520
 * @date 2020/3/25 22:17
 */
@Getter @Setter
public class AddPermission implements Serializable {

    private static final long serialVersionUID = -1977265749750558717L;

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
        AddPermission that = (AddPermission) o;
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
        return "AddPermissionDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}