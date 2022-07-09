package wang.liangchen.matrix.iam.authorization.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_roleset_subject")
@Table(name = "matrix_authorization_roleset_subject")
@AggregateRoot
public class AuthorizationRolesetSubject extends RootEntity {
    @Id
    @Column(name = "roleset_id")
    private Long rolesetId;
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRolesetSubject valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRolesetSubject.class);
    }

    public static AuthorizationRolesetSubject newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRolesetSubject.class);
    }

    public Long getRolesetId() {
        return this.rolesetId;
    }
    public void setRolesetId(Long rolesetId) {
        this.rolesetId = rolesetId;
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
        builder.append("AuthorizationRolesetSubject{");
        builder.append("rolesetId = ").append(rolesetId).append(", ");
        builder.append("subjectId = ").append(subjectId).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}