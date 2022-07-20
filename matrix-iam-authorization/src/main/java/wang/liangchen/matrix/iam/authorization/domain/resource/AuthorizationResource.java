package wang.liangchen.matrix.iam.authorization.domain.resource;

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
@Entity(name = "matrix_authorization_resource")
@Table(name = "matrix_authorization_resource")
@AggregateRoot
public class AuthorizationResource extends CommonEntity {
    @Id
    @Column(name = "resource_id")
    private Long resourceId;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "consumer_code")
    private String consumerCode;
    @Column(name = "resource_code")
    private String resourceCode;
    @Column(name = "resource_name")
    private String resourceName;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationResource valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationResource.class);
    }

    public static AuthorizationResource newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationResource.class);
    }

    public Long getResourceId() {
        return this.resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getParentId() {
        return this.parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getTenantCode() {
        return this.tenantCode;
    }
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
    public String getconsumerCode() {
        return this.consumerCode;
    }
    public void setconsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }
    public String getResourceCode() {
        return this.resourceCode;
    }
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }
    public String getResourceName() {
        return this.resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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
        builder.append("AuthorizationResource{");
        builder.append("resourceId = ").append(resourceId).append(", ");
        builder.append("parentId = ").append(parentId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("consumerCode = ").append(consumerCode).append(", ");
        builder.append("resourceCode = ").append(resourceCode).append(", ");
        builder.append("resourceName = ").append(resourceName).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}