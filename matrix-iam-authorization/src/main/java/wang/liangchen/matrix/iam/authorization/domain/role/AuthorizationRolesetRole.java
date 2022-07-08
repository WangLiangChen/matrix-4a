package wang.liangchen.matrix.iam.authorization.domain.role;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.CommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_roleset_role")
@Table(name = "matrix_authorization_roleset_role")
public class AuthorizationRolesetRole extends CommonEntity {
    @Id
    @Column(name = "roleset_id")
    private Long rolesetId;
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRolesetRole valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRolesetRole.class);
    }

    public static AuthorizationRolesetRole newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRolesetRole.class);
    }

    public Long getRolesetId() {
        return this.rolesetId;
    }
    public void setRolesetId(Long rolesetId) {
        this.rolesetId = rolesetId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        builder.append("AuthorizationRolesetRole{");
        builder.append("rolesetId = ").append(rolesetId).append(", ");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}