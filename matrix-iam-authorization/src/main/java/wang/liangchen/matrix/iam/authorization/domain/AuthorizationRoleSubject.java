package wang.liangchen.matrix.iam.authorization.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_role_subject")
@Table(name = "matrix_authorization_role_subject")
public class AuthorizationRoleSubject extends RootEntity {
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRoleSubject valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRoleSubject.class);
    }

    public static AuthorizationRoleSubject newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRoleSubject.class);
    }

    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        builder.append("AuthorizationRoleSubject{");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.append("subjectId = ").append(subjectId).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}