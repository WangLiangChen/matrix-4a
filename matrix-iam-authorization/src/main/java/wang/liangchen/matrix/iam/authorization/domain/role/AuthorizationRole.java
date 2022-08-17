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
@Entity(name = "matrix_authorization_role")
@Table(name = "matrix_authorization_role")
@AggregateRoot
public class AuthorizationRole extends CommonEntity {
    @Id
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "consumer_code")
    private String consumerCode;
    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "role_name")
    private String roleName;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRole valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRole.class);
    }

    public static AuthorizationRole newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRole.class);
    }

    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getTenantCode() {
        return this.tenantCode;
    }
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
    public String getConsumerCode() {
        return this.consumerCode;
    }
    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }
    public String getRoleCode() {
        return this.roleCode;
    }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        builder.append("AuthorizationRole{");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("consumerCode = ").append(consumerCode).append(", ");
        builder.append("roleCode = ").append(roleCode).append(", ");
        builder.append("roleName = ").append(roleName).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}