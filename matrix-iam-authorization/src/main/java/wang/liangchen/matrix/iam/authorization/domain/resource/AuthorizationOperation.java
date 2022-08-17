package wang.liangchen.matrix.iam.authorization.domain.resource;

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
@Entity(name = "matrix_authorization_operation")
@Table(name = "matrix_authorization_operation")
public class AuthorizationOperation extends CommonEntity {
    @Id
    @Column(name = "operation_id")
    private Long operationId;
    @Column(name = "resource_id")
    private Long resourceId;
    @Column(name = "operation_code")
    private String operationCode;
    @Column(name = "operation_name")
    private String operationName;
    @Column(name = "operation_dependence")
    private String operationDependence;
    @Column(name = "operation_uri")
    private String operationUri;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationOperation valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationOperation.class);
    }

    public static AuthorizationOperation newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationOperation.class);
    }

    public Long getOperationId() {
        return this.operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getOperationCode() {
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationDependence() {
        return this.operationDependence;
    }

    public void setOperationDependence(String operationDependence) {
        this.operationDependence = operationDependence;
    }

    public String getOperationUri() {
        return operationUri;
    }

    public void setOperationUri(String operationUri) {
        this.operationUri = operationUri;
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
        builder.append("AuthorizationOperation{");
        builder.append("operationId = ").append(operationId).append(", ");
        builder.append("resourceId = ").append(resourceId).append(", ");
        builder.append("operationCode = ").append(operationCode).append(", ");
        builder.append("operationName = ").append(operationName).append(", ");
        builder.append("operationDependence = ").append(operationDependence).append(", ");
        builder.append("operationUri = ").append(operationUri).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}