package wang.liangchen.matrix.iam.authorization.domain.subject;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_subject_extended_column")
@Table(name = "matrix_authorization_subject_extended_column")
public class AuthorizationSubjectExtendedColumn extends RootEntity {
    @Id
    @Column(name = "column_id")
    private Long columnId;
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "column_name")
    private String columnName;
    @Column(name = "column_value")
    private String columnValue;
    @Column(name = "column_comment")
    private String columnComment;

    public static AuthorizationSubjectExtendedColumn valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationSubjectExtendedColumn.class);
    }

    public static AuthorizationSubjectExtendedColumn newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationSubjectExtendedColumn.class);
    }

    public Long getColumnId() {
        return this.columnId;
    }
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
    public Long getSubjectId() {
        return this.subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    public String getColumnName() {
        return this.columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnValue() {
        return this.columnValue;
    }
    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }
    public String getColumnComment() {
        return this.columnComment;
    }
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthorizationSubjectExtendedColumn{");
        builder.append("columnId = ").append(columnId).append(", ");
        builder.append("subjectId = ").append(subjectId).append(", ");
        builder.append("columnName = ").append(columnName).append(", ");
        builder.append("columnValue = ").append(columnValue).append(", ");
        builder.append("columnComment = ").append(columnComment).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}