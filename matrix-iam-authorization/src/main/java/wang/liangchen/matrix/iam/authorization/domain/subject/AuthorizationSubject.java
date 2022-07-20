package wang.liangchen.matrix.iam.authorization.domain.subject;


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
@Entity(name = "matrix_authorization_subject")
@Table(name = "matrix_authorization_subject")
@AggregateRoot
public class AuthorizationSubject extends CommonEntity {
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "consumer_code")
    private String consumerCode;
    @Column(name = "subject_code")
    private String subjectCode;
    @Column(name = "subject_name")
    private String subjectName;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationSubject valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationSubject.class);
    }

    public static AuthorizationSubject newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationSubject.class);
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
        builder.append("AuthorizationSubject{");
        builder.append("subjectId = ").append(subjectId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("consumerCode = ").append(consumerCode).append(", ");
        builder.append("subjectCode = ").append(subjectCode).append(", ");
        builder.append("subjectName = ").append(subjectName).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}