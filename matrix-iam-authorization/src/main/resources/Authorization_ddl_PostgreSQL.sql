/*==============================================================*/
/* Table: authorization_subject                                 */
/*==============================================================*/
create table authorization_subject (
   subject_id           INT8                 not null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   subject_code         VARCHAR(72)          not null,
   subject_name         VARCHAR(36)          not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_SUBJECT primary key (subject_id)
);

comment on table authorization_subject is
'授权主体';

comment on column authorization_subject.subject_id is
'PrimaryKey';

comment on column authorization_subject.subject_code is
'标识';

comment on column authorization_subject.subject_name is
'名称';

comment on column authorization_subject.version is
'版本号,可用于乐观锁';

comment on column authorization_subject.owner is
'属主标识';

comment on column authorization_subject.creator is
'创建者标识';

comment on column authorization_subject.create_datetime is
'创建时间,长度6';

comment on column authorization_subject.modifier is
'最后修改者标识';

comment on column authorization_subject.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_subject.summary is
'简述说明';

comment on column authorization_subject.state is
'状态';

/*==============================================================*/
/* Index: authorization_subject_PK                              */
/*==============================================================*/
create unique index authorization_subject_PK on authorization_subject (
subject_id
);

/*==============================================================*/
/* Table: authorization_group                                   */
/*==============================================================*/
create table authorization_group (
   group_id             INT8                 not null,
   parent_id            INT8                 null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   group_code           VARCHAR(36)          not null,
   group_name           VARCHAR(36)          not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_GROUP primary key (group_id)
);

comment on table authorization_group is
'授权主体所属的组,类似组织机构';

comment on column authorization_group.group_id is
'PrimaryKey';

comment on column authorization_group.parent_id is
'PrimaryKey';

comment on column authorization_group.group_code is
'标识';

comment on column authorization_group.group_name is
'名称';

comment on column authorization_group.version is
'版本号,可用于乐观锁';

comment on column authorization_group.owner is
'属主标识';

comment on column authorization_group.creator is
'创建者标识';

comment on column authorization_group.create_datetime is
'创建时间,长度6';

comment on column authorization_group.modifier is
'最后修改者标识';

comment on column authorization_group.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_group.summary is
'简述说明';

comment on column authorization_group.state is
'状态';

/*==============================================================*/
/* Index: authorization_group_PK                                */
/*==============================================================*/
create unique index authorization_group_PK on authorization_group (
group_id
);

/*==============================================================*/
/* Index: group_self_FK                                         */
/*==============================================================*/
create  index group_self_FK on authorization_group (
parent_id
);
/*==============================================================*/
/* Table: authorization_role                                    */
/*==============================================================*/
create table authorization_role (
   role_id              INT8                 not null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   role_code            VARCHAR(36)          not null,
   role_name            VARCHAR(36)          not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_ROLE primary key (role_id)
);

comment on table authorization_role is
'授权主体所属的角色';

comment on column authorization_role.role_id is
'PrimaryKey';

comment on column authorization_role.role_code is
'标识';

comment on column authorization_role.role_name is
'名称';

comment on column authorization_role.version is
'版本号,可用于乐观锁';

comment on column authorization_role.owner is
'属主标识';

comment on column authorization_role.creator is
'创建者标识';

comment on column authorization_role.create_datetime is
'创建时间,长度6';

comment on column authorization_role.modifier is
'最后修改者标识';

comment on column authorization_role.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_role.summary is
'简述说明';

comment on column authorization_role.state is
'状态';

/*==============================================================*/
/* Index: authorization_role_PK                                 */
/*==============================================================*/
create unique index authorization_role_PK on authorization_role (
role_id
);
/*==============================================================*/
/* Table: authorization_subject_group                           */
/*==============================================================*/
create table authorization_subject_group (
   subject_id           INT8                 null,
   group_id             INT8                 null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null
);

comment on table authorization_subject_group is
'主体_组关系';

comment on column authorization_subject_group.subject_id is
'PrimaryKey';

comment on column authorization_subject_group.group_id is
'PrimaryKey';

comment on column authorization_subject_group.version is
'版本号,可用于乐观锁';

comment on column authorization_subject_group.owner is
'属主标识';

comment on column authorization_subject_group.creator is
'创建者标识';

comment on column authorization_subject_group.create_datetime is
'创建时间,长度6';

comment on column authorization_subject_group.modifier is
'最后修改者标识';

comment on column authorization_subject_group.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_subject_group.summary is
'简述说明';

comment on column authorization_subject_group.state is
'状态';

/*==============================================================*/
/* Index: subject_group_FK                                      */
/*==============================================================*/
create  index subject_group_FK on authorization_subject_group (
subject_id
);

/*==============================================================*/
/* Index: group_subject_FK                                      */
/*==============================================================*/
create  index group_subject_FK on authorization_subject_group (
group_id
);
/*==============================================================*/
/* Table: authorization_subject_role                            */
/*==============================================================*/
create table authorization_subject_role (
   subject_id           INT8                 null,
   role_id              INT8                 null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null
);

comment on table authorization_subject_role is
'主体_角色关系';

comment on column authorization_subject_role.subject_id is
'PrimaryKey';

comment on column authorization_subject_role.role_id is
'PrimaryKey';

comment on column authorization_subject_role.version is
'版本号,可用于乐观锁';

comment on column authorization_subject_role.owner is
'属主标识';

comment on column authorization_subject_role.creator is
'创建者标识';

comment on column authorization_subject_role.create_datetime is
'创建时间,长度6';

comment on column authorization_subject_role.modifier is
'最后修改者标识';

comment on column authorization_subject_role.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_subject_role.summary is
'简述说明';

comment on column authorization_subject_role.state is
'状态';

/*==============================================================*/
/* Index: subject_role_FK                                       */
/*==============================================================*/
create  index subject_role_FK on authorization_subject_role (
subject_id
);

/*==============================================================*/
/* Index: role_subject_FK                                       */
/*==============================================================*/
create  index role_subject_FK on authorization_subject_role (
role_id
);

/*==============================================================*/
/* Table: authorization_resource                                */
/*==============================================================*/
create table authorization_resource (
   resource_id          INT8                 not null,
   parent_id            INT8                 null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   resource_code        VARCHAR(36)          not null,
   resource_name        VARCHAR(36)          not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_RESOURCE primary key (resource_id)
);

comment on table authorization_resource is
'被授权的资源,系统中的实体对象定义为资源，比如订单、商品';

comment on column authorization_resource.resource_id is
'PrimaryKey';

comment on column authorization_resource.parent_id is
'PrimaryKey';

comment on column authorization_resource.resource_code is
'标识';

comment on column authorization_resource.resource_name is
'名称';

comment on column authorization_resource.version is
'版本号,可用于乐观锁';

comment on column authorization_resource.owner is
'属主标识';

comment on column authorization_resource.creator is
'创建者标识';

comment on column authorization_resource.create_datetime is
'创建时间,长度6';

comment on column authorization_resource.modifier is
'最后修改者标识';

comment on column authorization_resource.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_resource.summary is
'简述说明';

comment on column authorization_resource.state is
'状态';

/*==============================================================*/
/* Index: authorization_resource_PK                             */
/*==============================================================*/
create unique index authorization_resource_PK on authorization_resource (
resource_id
);

/*==============================================================*/
/* Index: resource_self_FK                                      */
/*==============================================================*/
create  index resource_self_FK on authorization_resource (
parent_id
);

/*==============================================================*/
/* Table: authorization_operation                               */
/*==============================================================*/
create table authorization_operation (
   operation_id         INT8                 not null,
   resource_id          INT8                 null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   operation_code       VARCHAR(36)          not null,
   operation_name       VARCHAR(36)          not null,
   operation_dependence VARCHAR(120)         not null,
   operation_uri        VARCHAR(200)         not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_OPERATION primary key (operation_id)
);

comment on table authorization_operation is
'被授权资源的操作,定义对指定资源的CRUD等操作.';

comment on column authorization_operation.operation_id is
'Primarykey';

comment on column authorization_operation.resource_id is
'PrimaryKey';

comment on column authorization_operation.operation_code is
'标识';

comment on column authorization_operation.operation_name is
'名称';

comment on column authorization_operation.operation_dependence is
'依赖的同一资源下的操作,operation_code以半角分号隔开';

comment on column authorization_operation.operation_uri is
'[{"method":"PUT","path":"/account/*"}] Ant Pattern';

comment on column authorization_operation.version is
'版本号,可用于乐观锁';

comment on column authorization_operation.owner is
'属主标识';

comment on column authorization_operation.creator is
'创建者标识';

comment on column authorization_operation.create_datetime is
'创建时间,长度6';

comment on column authorization_operation.modifier is
'最后修改者标识';

comment on column authorization_operation.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_operation.summary is
'简述说明';

comment on column authorization_operation.state is
'状态';

/*==============================================================*/
/* Index: authorization_operation_PK                            */
/*==============================================================*/
create unique index authorization_operation_PK on authorization_operation (
operation_id
);

/*==============================================================*/
/* Index: resource_operation_FK                                 */
/*==============================================================*/
create  index resource_operation_FK on authorization_operation (
resource_id
);

/*==============================================================*/
/* Table: authorization_role_resource_operation                       */
/*==============================================================*/
create table authorization_role_resource_operation (
   role_id              INT8                 not null,
   resource_id          INT8                 not null,
   operation_id         INT8                 not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_ROLE_RESOURCE primary key (role_id, resource_id, operation_id)
);

comment on column authorization_role_resource_operation.role_id is
'PrimaryKey';

comment on column authorization_role_resource_operation.resource_id is
'PrimaryKey';

comment on column authorization_role_resource_operation.operation_id is
'Primarykey';

comment on column authorization_role_resource_operation.version is
'版本号,可用于乐观锁';

comment on column authorization_role_resource_operation.owner is
'属主标识';

comment on column authorization_role_resource_operation.creator is
'创建者标识';

comment on column authorization_role_resource_operation.create_datetime is
'创建时间,长度6';

comment on column authorization_role_resource_operation.modifier is
'最后修改者标识';

comment on column authorization_role_resource_operation.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_role_resource_operation.summary is
'简述说明';

comment on column authorization_role_resource_operation.state is
'状态';

/*==============================================================*/
/* Index: authorization_role_resource_operation_PK                       */
/*==============================================================*/
create unique index authorization_role_resource_operation_PK on authorization_role_resource_operation (
role_id,
resource_id,
operation_id
);

/*==============================================================*/
/* Index: role_resource_operation_FK                            */
/*==============================================================*/
create  index role_resource_operation_FK on authorization_role_resource_operation (
role_id
);

/*==============================================================*/
/* Index: resource_role_operation_FK                            */
/*==============================================================*/
create  index resource_role_operation_FK on authorization_role_resource_operation (
resource_id
);

/*==============================================================*/
/* Index: operation_role_resource_FK                            */
/*==============================================================*/
create  index operation_role_resource_FK on authorization_role_resource_operation (
operation_id
);
/*==============================================================*/
/* Table: authorization_attribute                               */
/*==============================================================*/
create table authorization_attribute (
   attribute_id         INT8                 not null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   attribute_key        VARCHAR(36)          not null,
   attribute_name       VARCHAR(36)          not null,
   attribute_type       VARCHAR(20)          not null,
   value_type           VARCHAR(36)          not null,
   value_candidate      VARCHAR(500)         not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_ATTRIBUTE primary key (attribute_id)
);

comment on table authorization_attribute is
'用于ABAC和数据权限控制的属性';

comment on column authorization_attribute.attribute_type is
'Resource,Subject,Action';

comment on column authorization_attribute.version is
'版本号,可用于乐观锁';

comment on column authorization_attribute.owner is
'属主标识';

comment on column authorization_attribute.creator is
'创建者标识';

comment on column authorization_attribute.create_datetime is
'创建时间,长度6';

comment on column authorization_attribute.modifier is
'最后修改者标识';

comment on column authorization_attribute.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_attribute.summary is
'简述说明';

comment on column authorization_attribute.state is
'状态';

/*==============================================================*/
/* Index: authorization_attribute_PK                            */
/*==============================================================*/
create unique index authorization_attribute_PK on authorization_attribute (
attribute_id
);

/*==============================================================*/
/* Table: authorization_policy                                  */
/*==============================================================*/
create table authorization_policy (
   policy_id            INT8                 not null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   policy_payload       VARCHAR(2000)        not null,
   policy_type          VARCHAR(36)          not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHORIZATION_POLICY primary key (policy_id)
);

comment on table authorization_policy is
'ABAC策略/规则';

comment on column authorization_policy.policy_payload is
'Json结构';

comment on column authorization_policy.policy_type is
'FILTER;ABAC';

comment on column authorization_policy.version is
'版本号,可用于乐观锁';

comment on column authorization_policy.owner is
'属主标识';

comment on column authorization_policy.creator is
'创建者标识';

comment on column authorization_policy.create_datetime is
'创建时间,长度6';

comment on column authorization_policy.modifier is
'最后修改者标识';

comment on column authorization_policy.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_policy.summary is
'简述说明';

comment on column authorization_policy.state is
'状态';

/*==============================================================*/
/* Index: authorization_policy_PK                               */
/*==============================================================*/
create unique index authorization_policy_PK on authorization_policy (
policy_id
);

/*==============================================================*/
/* Table: authorization_role_policy                             */
/*==============================================================*/
create table authorization_role_policy (
   role_id              INT8                 null,
   policy_id            INT8                 null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null
);

comment on column authorization_role_policy.role_id is
'PrimaryKey';

comment on column authorization_role_policy.version is
'版本号,可用于乐观锁';

comment on column authorization_role_policy.owner is
'属主标识';

comment on column authorization_role_policy.creator is
'创建者标识';

comment on column authorization_role_policy.create_datetime is
'创建时间,长度6';

comment on column authorization_role_policy.modifier is
'最后修改者标识';

comment on column authorization_role_policy.modify_datetime is
'最后修改时间,长度6';

comment on column authorization_role_policy.summary is
'简述说明';

comment on column authorization_role_policy.state is
'状态';

/*==============================================================*/
/* Index: role_policy_FK                                        */
/*==============================================================*/
create  index role_policy_FK on authorization_role_policy (
role_id
);

/*==============================================================*/
/* Index: policy_role_FK                                        */
/*==============================================================*/
create  index policy_role_FK on authorization_role_policy (
policy_id
);