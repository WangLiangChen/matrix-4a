package wang.liangchen.matrix.iam.authorization.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.CommonEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_group_subject")
@Table(name = "matrix_authorization_group_subject")
@AggregateRoot
public class AuthorizationGroupSubject extends CommonEntity {
    @Id
    @Column(name = "group_id")
    private Long groupId;
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationGroupSubject valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationGroupSubject.class);
    }

    public static AuthorizationGroupSubject newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationGroupSubject.class);
    }

    public Long getGroupId() {
        return this.groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public Long getSubjectId() {
        return this.subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthorizationGroupSubject{");
        builder.append("groupId = ").append(groupId).append(", ");
        builder.append("subjectId = ").append(subjectId).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}