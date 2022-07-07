package wang.liangchen.matrix.iam.authorization.domain.aggregate.subject;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_subject")
@Table(name = "matrix_authorization_subject")
@AggregateRoot
public class AuthorizationSubject extends RootEntity {
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "app_code")
    private String appCode;
    @Column(name = "subject_code")
    private String subjectCode;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "data_mode")
    private Short dataMode;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "owner")
    private String owner;
    @Column(name = "creator")
    private String creator;
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
    @Column(name = "modifier")
    private String modifier;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDatetime;
    @Column(name = "summary")
    private String summary;
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
    public String getAppCode() {
        return this.appCode;
    }
    public void setAppCode(String appCode) {
        this.appCode = appCode;
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
    public Short getDataMode() {
        return this.dataMode;
    }
    public void setDataMode(Short dataMode) {
        this.dataMode = dataMode;
    }
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getCreator() {
        return this.creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public LocalDateTime getCreateDatetime() {
        return this.createDatetime;
    }
    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }
    public String getModifier() {
        return this.modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public LocalDateTime getModifyDatetime() {
        return this.modifyDatetime;
    }
    public void setModifyDatetime(LocalDateTime modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
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
        builder.append("appCode = ").append(appCode).append(", ");
        builder.append("subjectCode = ").append(subjectCode).append(", ");
        builder.append("subjectName = ").append(subjectName).append(", ");
        builder.append("dataMode = ").append(dataMode).append(", ");
        builder.append("version = ").append(version).append(", ");
        builder.append("sort = ").append(sort).append(", ");
        builder.append("owner = ").append(owner).append(", ");
        builder.append("creator = ").append(creator).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("modifier = ").append(modifier).append(", ");
        builder.append("modifyDatetime = ").append(modifyDatetime).append(", ");
        builder.append("summary = ").append(summary).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}