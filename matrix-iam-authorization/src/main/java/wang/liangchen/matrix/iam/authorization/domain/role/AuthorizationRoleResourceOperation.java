package wang.liangchen.matrix.iam.authorization.domain.role;

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
@Entity(name = "matrix_authorization_role_resource_operation")
@Table(name = "matrix_authorization_role_resource_operation")
@AggregateRoot
public class AuthorizationRoleResourceOperation extends CommonEntity {
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @Id
    @Column(name = "resource_id")
    private Long resourceId;
    @Id
    @Column(name = "operation_id")
    private Long operationId;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRoleResourceOperation valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRoleResourceOperation.class);
    }

    public static AuthorizationRoleResourceOperation newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRoleResourceOperation.class);
    }

    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getOperationId() {
        return this.operationId;
    }
    public void setOperationId(Long operationId) {
        this.operationId = operationId;
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
        builder.append("AuthorizationRoleResourceOperation{");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.append("resourceId = ").append(resourceId).append(", ");
        builder.append("operationId = ").append(operationId).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}