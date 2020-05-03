package com.pytap.project.entity;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private Long id;

    private Long projectId;

    private Long executor;

    private Long initiator;

    private String type;

    private Date startingTime;

    private Date deadline;

    private Short status;

    private Short priority;

    private Date createTime;

    private String explanation;

    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getExecutor() {
        return executor;
    }

    public void setExecutor(Long executor) {
        this.executor = executor;
    }

    public Long getInitiator() {
        return initiator;
    }

    public void setInitiator(Long initiator) {
        this.initiator = initiator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", executor=").append(executor);
        sb.append(", initiator=").append(initiator);
        sb.append(", type=").append(type);
        sb.append(", startingTime=").append(startingTime);
        sb.append(", deadline=").append(deadline);
        sb.append(", status=").append(status);
        sb.append(", priority=").append(priority);
        sb.append(", createTime=").append(createTime);
        sb.append(", explanation=").append(explanation);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}