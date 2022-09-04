/*==============================================================*/
/* Table: matrix_authorization_allowlist                               */
/*==============================================================*/
create table matrix_authorization_allowlist (
   allowlist_id         int8                 not null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   permission_uri       varchar(200)         not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_allowlist primary key (allowlist_id)
);

comment on table matrix_authorization_allowlist is
'白名单';

comment on column matrix_authorization_allowlist.permission_uri is
'[{"method":"PUT","ant_path":"/account/*"}]';

comment on column matrix_authorization_allowlist.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_allowlist.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_allowlist.sort is
'默认排序';

comment on column matrix_authorization_allowlist.owner is
'属主标识';

comment on column matrix_authorization_allowlist.creator is
'创建者标识';

comment on column matrix_authorization_allowlist.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_allowlist.modifier is
'最后修改者标识';

comment on column matrix_authorization_allowlist.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_allowlist.summary is
'简述说明';

comment on column matrix_authorization_allowlist.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_allowlist_pk                            */
/*==============================================================*/
create unique index matrix_authorization_allowlist_pk on matrix_authorization_allowlist (
allowlist_id
);

/*==============================================================*/
/* Table: matrix_authorization_group                                   */
/*==============================================================*/
create table matrix_authorization_group (
   group_id             int8                 not null,
   parent_id            int8                 null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   group_code           varchar(36)          not null,
   group_name           varchar(36)          not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_group primary key (group_id)
);

comment on table matrix_authorization_group is
'被授权主体所属的组,用于类似组织机构的属性';

comment on column matrix_authorization_group.group_id is
'PrimaryKey';

comment on column matrix_authorization_group.parent_id is
'PrimaryKey';

comment on column matrix_authorization_group.group_code is
'标识';

comment on column matrix_authorization_group.group_name is
'名称';

comment on column matrix_authorization_group.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_group.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_group.sort is
'默认排序';

comment on column matrix_authorization_group.owner is
'属主标识';

comment on column matrix_authorization_group.creator is
'创建者标识';

comment on column matrix_authorization_group.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_group.modifier is
'最后修改者标识';

comment on column matrix_authorization_group.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_group.summary is
'简述说明';

comment on column matrix_authorization_group.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_group_pk                                */
/*==============================================================*/
create unique index matrix_authorization_group_pk on matrix_authorization_group (
group_id
);

/*==============================================================*/
/* Index: group_self_fk                                         */
/*==============================================================*/
create  index group_self_fk on matrix_authorization_group (
parent_id
);

/*==============================================================*/
/* Table: matrix_authorization_group_subject                           */
/*==============================================================*/
create table matrix_authorization_group_subject (
   group_id             int8                 not null,
   subject_id           int8                 not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_group_subject primary key (group_id, subject_id)
);

comment on table matrix_authorization_group_subject is
'组 主体关系';

comment on column matrix_authorization_group_subject.group_id is
'PrimaryKey';

comment on column matrix_authorization_group_subject.subject_id is
'PrimaryKey';

comment on column matrix_authorization_group_subject.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_group_subject.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_group_subject.sort is
'默认排序';

comment on column matrix_authorization_group_subject.owner is
'属主标识';

comment on column matrix_authorization_group_subject.creator is
'创建者标识';

comment on column matrix_authorization_group_subject.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_group_subject.modifier is
'最后修改者标识';

comment on column matrix_authorization_group_subject.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_group_subject.summary is
'简述说明';

comment on column matrix_authorization_group_subject.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_group_subject_pk                        */
/*==============================================================*/
create unique index matrix_authorization_group_subject_pk on matrix_authorization_group_subject (
group_id,
subject_id
);

/*==============================================================*/
/* Index: group_subject_fk                                      */
/*==============================================================*/
create  index group_subject_fk on matrix_authorization_group_subject (
group_id
);

/*==============================================================*/
/* Index: subject_group_fk                                      */
/*==============================================================*/
create  index subject_group_fk on matrix_authorization_group_subject (
subject_id
);

/*==============================================================*/
/* Table: matrix_authorization_operation                               */
/*==============================================================*/
create table matrix_authorization_operation (
   operation_id         int8                 not null,
   resource_id          int8                 null,
   operation_code       varchar(36)          not null,
   operation_name       varchar(36)          not null,
   operation_dependency varchar(120)         not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_operation primary key (operation_id)
);

comment on table matrix_authorization_operation is
'被授权资源的操作,定义对指定资源的CRUD等操作.';

comment on column matrix_authorization_operation.operation_id is
'Primarykey';

comment on column matrix_authorization_operation.resource_id is
'PrimaryKey';

comment on column matrix_authorization_operation.operation_code is
'标识';

comment on column matrix_authorization_operation.operation_name is
'名称';

comment on column matrix_authorization_operation.operation_dependency is
'依赖的操作,operation_code以半角分号隔开';

comment on column matrix_authorization_operation.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_operation.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_operation.sort is
'默认排序';

comment on column matrix_authorization_operation.owner is
'属主标识';

comment on column matrix_authorization_operation.creator is
'创建者标识';

comment on column matrix_authorization_operation.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_operation.modifier is
'最后修改者标识';

comment on column matrix_authorization_operation.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_operation.summary is
'简述说明';

comment on column matrix_authorization_operation.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_operation_pk                            */
/*==============================================================*/
create unique index matrix_authorization_operation_pk on matrix_authorization_operation (
operation_id
);

/*==============================================================*/
/* Index: resource_operation_fk                                 */
/*==============================================================*/
create  index resource_operation_fk on matrix_authorization_operation (
resource_id
);

/*==============================================================*/
/* Table: matrix_authorization_permission                              */
/*==============================================================*/
create table matrix_authorization_permission (
   permission_id        int8                 not null,
   resource_id          int8                 null,
   operation_id         int8                 null,
   role_id              int8                 null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   permission_code      varchar(73)          not null,
   permission_name      varchar(100)         not null,
   perimission_dependency varchar(200)         not null,
   permission_uri       varchar(200)         not null,
   permission_label     varchar(200)         not null,
   permission_rule      varchar(200)         not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp            not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp            not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_authorization_permission primary key (permission_id)
);

comment on table matrix_authorization_permission is
'被授权资源操作对应的权限
uri
label
rule';

comment on column matrix_authorization_permission.permission_id is
'PrimaryKey';

comment on column matrix_authorization_permission.resource_id is
'PrimaryKey';

comment on column matrix_authorization_permission.operation_id is
'Primarykey';

comment on column matrix_authorization_permission.role_id is
'PrimaryKey';

comment on column matrix_authorization_permission.permission_code is
'权限码:1、自定义 2、resource_code:operation_code';

comment on column matrix_authorization_permission.permission_name is
'权限名称:1、自定义 2、资源名称/操作名称';

comment on column matrix_authorization_permission.perimission_dependency is
'依赖的权限,permission_code以半角分号隔开';

comment on column matrix_authorization_permission.permission_uri is
'[{"method":"PUT","ant_path":"/account/*"}]';

comment on column matrix_authorization_permission.permission_label is
'[{"k":"","v":}]';

comment on column matrix_authorization_permission.permission_rule is
'SPEL ';

comment on column matrix_authorization_permission.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_permission.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_permission.sort is
'默认排序';

comment on column matrix_authorization_permission.owner is
'属主标识';

comment on column matrix_authorization_permission.creator is
'创建者标识';

comment on column matrix_authorization_permission.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_permission.modifier is
'最后修改者标识';

comment on column matrix_authorization_permission.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_permission.summary is
'简述说明';

comment on column matrix_authorization_permission.state is
'状态';

/*==============================================================*/
/* Index: authorization_permission_pk                           */
/*==============================================================*/
create unique index authorization_permission_pk on matrix_authorization_permission (
permission_id
);

/*==============================================================*/
/* Index: resource_permission_fk                                */
/*==============================================================*/
create  index resource_permission_fk on matrix_authorization_permission (
resource_id
);

/*==============================================================*/
/* Index: operation_permission_fk                               */
/*==============================================================*/
create  index operation_permission_fk on matrix_authorization_permission (
operation_id
);

/*==============================================================*/
/* Index: role_permission_fk                                    */
/*==============================================================*/
create  index role_permission_fk on matrix_authorization_permission (
role_id
);

/*==============================================================*/
/* Table: matrix_authorization_resource                                */
/*==============================================================*/
create table matrix_authorization_resource (
   resource_id          int8                 not null,
   parent_id            int8                 null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   resource_code        varchar(36)          not null,
   resource_name        varchar(36)          not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_resource primary key (resource_id)
);

comment on table matrix_authorization_resource is
'被授权的资源,资源的定义可以参照RESTful的资源';

comment on column matrix_authorization_resource.resource_id is
'PrimaryKey';

comment on column matrix_authorization_resource.parent_id is
'PrimaryKey';

comment on column matrix_authorization_resource.resource_code is
'标识';

comment on column matrix_authorization_resource.resource_name is
'名称';

comment on column matrix_authorization_resource.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_resource.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_resource.sort is
'默认排序';

comment on column matrix_authorization_resource.owner is
'属主标识';

comment on column matrix_authorization_resource.creator is
'创建者标识';

comment on column matrix_authorization_resource.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_resource.modifier is
'最后修改者标识';

comment on column matrix_authorization_resource.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_resource.summary is
'简述说明';

comment on column matrix_authorization_resource.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_resource_pk                             */
/*==============================================================*/
create unique index matrix_authorization_resource_pk on matrix_authorization_resource (
resource_id
);

/*==============================================================*/
/* Index: resource_self_fk                                      */
/*==============================================================*/
create  index resource_self_fk on matrix_authorization_resource (
parent_id
);

/*==============================================================*/
/* Table: matrix_authorization_role                                    */
/*==============================================================*/
create table matrix_authorization_role (
   role_id              int8                 not null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   role_code            varchar(36)          not null,
   role_name            varchar(36)          not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_role primary key (role_id)
);

comment on table matrix_authorization_role is
'被授权主体所属的角色';

comment on column matrix_authorization_role.role_id is
'PrimaryKey';

comment on column matrix_authorization_role.role_code is
'标识';

comment on column matrix_authorization_role.role_name is
'名称';

comment on column matrix_authorization_role.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_role.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_role.sort is
'默认排序';

comment on column matrix_authorization_role.owner is
'属主标识';

comment on column matrix_authorization_role.creator is
'创建者标识';

comment on column matrix_authorization_role.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_role.modifier is
'最后修改者标识';

comment on column matrix_authorization_role.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_role.summary is
'简述说明';

comment on column matrix_authorization_role.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_role_pk                                 */
/*==============================================================*/
create unique index matrix_authorization_role_pk on matrix_authorization_role (
role_id
);

/*==============================================================*/
/* Table: matrix_authorization_role_resource_operation                 */
/*==============================================================*/
create table matrix_authorization_role_resource_operation (
   role_id              int8                 not null,
   resource_id          int8                 not null,
   operation_id         int8                 not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_role_resource primary key (role_id, resource_id, operation_id)
);

comment on column matrix_authorization_role_resource_operation.role_id is
'PrimaryKey';

comment on column matrix_authorization_role_resource_operation.resource_id is
'PrimaryKey';

comment on column matrix_authorization_role_resource_operation.operation_id is
'Primarykey';

comment on column matrix_authorization_role_resource_operation.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_role_resource_operation.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_role_resource_operation.sort is
'默认排序';

comment on column matrix_authorization_role_resource_operation.owner is
'属主标识';

comment on column matrix_authorization_role_resource_operation.creator is
'创建者标识';

comment on column matrix_authorization_role_resource_operation.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_role_resource_operation.modifier is
'最后修改者标识';

comment on column matrix_authorization_role_resource_operation.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_role_resource_operation.summary is
'简述说明';

comment on column matrix_authorization_role_resource_operation.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_role_resource_operation_pk              */
/*==============================================================*/
create unique index matrix_authorization_role_resource_operation_pk on matrix_authorization_role_resource_operation (
role_id,
resource_id,
operation_id
);

/*==============================================================*/
/* Index: role_resource_operation_fk                            */
/*==============================================================*/
create  index role_resource_operation_fk on matrix_authorization_role_resource_operation (
role_id
);

/*==============================================================*/
/* Index: resource_role_operation_fk                            */
/*==============================================================*/
create  index resource_role_operation_fk on matrix_authorization_role_resource_operation (
resource_id
);

/*==============================================================*/
/* Index: operation_role_resource_fk                            */
/*==============================================================*/
create  index operation_role_resource_fk on matrix_authorization_role_resource_operation (
operation_id
);

/*==============================================================*/
/* Table: matrix_authorization_role_subject                            */
/*==============================================================*/
create table matrix_authorization_role_subject (
   role_id              int8                 not null,
   subject_id           int8                 not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_role_subject primary key (role_id, subject_id)
);

comment on table matrix_authorization_role_subject is
'角色 主体关系';

comment on column matrix_authorization_role_subject.role_id is
'PrimaryKey';

comment on column matrix_authorization_role_subject.subject_id is
'PrimaryKey';

comment on column matrix_authorization_role_subject.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_role_subject.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_role_subject.sort is
'默认排序';

comment on column matrix_authorization_role_subject.owner is
'属主标识';

comment on column matrix_authorization_role_subject.creator is
'创建者标识';

comment on column matrix_authorization_role_subject.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_role_subject.modifier is
'最后修改者标识';

comment on column matrix_authorization_role_subject.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_role_subject.summary is
'简述说明';

comment on column matrix_authorization_role_subject.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_role_subject_pk                         */
/*==============================================================*/
create unique index matrix_authorization_role_subject_pk on matrix_authorization_role_subject (
role_id,
subject_id
);

/*==============================================================*/
/* Index: role_subject_fk                                       */
/*==============================================================*/
create  index role_subject_fk on matrix_authorization_role_subject (
role_id
);

/*==============================================================*/
/* Index: subject_role_fk                                       */
/*==============================================================*/
create  index subject_role_fk on matrix_authorization_role_subject (
subject_id
);

/*==============================================================*/
/* Table: matrix_authorization_roleset                                 */
/*==============================================================*/
create table matrix_authorization_roleset (
   roleset_id           int8                 not null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   roleset_name         varchar(36)          not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_roleset primary key (roleset_id)
);

comment on table matrix_authorization_roleset is
'被授权主体所属的角色组';

comment on column matrix_authorization_roleset.roleset_id is
'PrimaryKey';

comment on column matrix_authorization_roleset.roleset_name is
'名称';

comment on column matrix_authorization_roleset.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_roleset.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_roleset.sort is
'默认排序';

comment on column matrix_authorization_roleset.owner is
'属主标识';

comment on column matrix_authorization_roleset.creator is
'创建者标识';

comment on column matrix_authorization_roleset.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_roleset.modifier is
'最后修改者标识';

comment on column matrix_authorization_roleset.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_roleset.summary is
'简述说明';

comment on column matrix_authorization_roleset.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_roleset_pk                              */
/*==============================================================*/
create unique index matrix_authorization_roleset_pk on matrix_authorization_roleset (
roleset_id
);

/*==============================================================*/
/* Table: matrix_authorization_roleset_role                            */
/*==============================================================*/
create table matrix_authorization_roleset_role (
   roleset_id           int8                 not null,
   role_id              int8                 not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_roleset_role primary key (roleset_id, role_id)
);

comment on table matrix_authorization_roleset_role is
'角色组 角色关系';

comment on column matrix_authorization_roleset_role.roleset_id is
'PrimaryKey';

comment on column matrix_authorization_roleset_role.role_id is
'PrimaryKey';

comment on column matrix_authorization_roleset_role.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_roleset_role.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_roleset_role.sort is
'默认排序';

comment on column matrix_authorization_roleset_role.owner is
'属主标识';

comment on column matrix_authorization_roleset_role.creator is
'创建者标识';

comment on column matrix_authorization_roleset_role.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_roleset_role.modifier is
'最后修改者标识';

comment on column matrix_authorization_roleset_role.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_roleset_role.summary is
'简述说明';

comment on column matrix_authorization_roleset_role.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_roleset_role_pk                         */
/*==============================================================*/
create unique index matrix_authorization_roleset_role_pk on matrix_authorization_roleset_role (
roleset_id,
role_id
);

/*==============================================================*/
/* Index: roleset_role_fk                                       */
/*==============================================================*/
create  index roleset_role_fk on matrix_authorization_roleset_role (
roleset_id
);

/*==============================================================*/
/* Index: role_rolegroup_fk                                     */
/*==============================================================*/
create  index role_rolegroup_fk on matrix_authorization_roleset_role (
role_id
);

/*==============================================================*/
/* Table: matrix_authorization_roleset_subject                         */
/*==============================================================*/
create table matrix_authorization_roleset_subject (
   roleset_id           int8                 not null,
   subject_id           int8                 not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_roleset_subje primary key (roleset_id, subject_id)
);

comment on table matrix_authorization_roleset_subject is
'角色组 主体关系';

comment on column matrix_authorization_roleset_subject.roleset_id is
'PrimaryKey';

comment on column matrix_authorization_roleset_subject.subject_id is
'PrimaryKey';

comment on column matrix_authorization_roleset_subject.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_roleset_subject.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_roleset_subject.sort is
'默认排序';

comment on column matrix_authorization_roleset_subject.owner is
'属主标识';

comment on column matrix_authorization_roleset_subject.creator is
'创建者标识';

comment on column matrix_authorization_roleset_subject.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_roleset_subject.modifier is
'最后修改者标识';

comment on column matrix_authorization_roleset_subject.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_roleset_subject.summary is
'简述说明';

comment on column matrix_authorization_roleset_subject.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_roleset_subject_pk                      */
/*==============================================================*/
create unique index matrix_authorization_roleset_subject_pk on matrix_authorization_roleset_subject (
roleset_id,
subject_id
);

/*==============================================================*/
/* Index: roleset_subject_fk                                    */
/*==============================================================*/
create  index roleset_subject_fk on matrix_authorization_roleset_subject (
roleset_id
);

/*==============================================================*/
/* Index: subject_roleset_fk                                    */
/*==============================================================*/
create  index subject_roleset_fk on matrix_authorization_roleset_subject (
subject_id
);

/*==============================================================*/
/* Table: matrix_authorization_subject                                 */
/*==============================================================*/
create table matrix_authorization_subject (
   subject_id           int8                 not null,
   tenant_code          varchar(36)          not null,
   app_code             varchar(36)          not null,
   subject_code         varchar(72)          not null,
   subject_name         varchar(36)          not null,
   data_mode            int2                 not null default 0,
   version              int4                 not null default 0,
   sort                 int4                 not null default 0,
   owner                varchar(36)          not null default '',
   creator              varchar(36)          not null default '',
   create_datetime      timestamp                 not null,
   modifier             varchar(36)          not null default '',
   modify_datetime      timestamp                 not null,
   summary              varchar(200)         not null default '',
   state                varchar(36)          not null,
   constraint pk_matrix_authorization_subject primary key (subject_id)
);

comment on table matrix_authorization_subject is
'被授权的主体';

comment on column matrix_authorization_subject.subject_id is
'PrimaryKey';

comment on column matrix_authorization_subject.subject_code is
'标识,如账户名.注意:如账户来源于账户系统或认证系统,使用\组合来确保唯一.如 WEIXIN\LiangChenWang';

comment on column matrix_authorization_subject.subject_name is
'名称';

comment on column matrix_authorization_subject.data_mode is
'权限模式 4:Retrieve:2:Update;1:Delete;0:NONE;-1:ALL; ';

comment on column matrix_authorization_subject.version is
'版本号,可用于乐观锁';

comment on column matrix_authorization_subject.sort is
'默认排序';

comment on column matrix_authorization_subject.owner is
'属主标识';

comment on column matrix_authorization_subject.creator is
'创建者标识';

comment on column matrix_authorization_subject.create_datetime is
'创建时间,长度6';

comment on column matrix_authorization_subject.modifier is
'最后修改者标识';

comment on column matrix_authorization_subject.modify_datetime is
'最后修改时间,长度6';

comment on column matrix_authorization_subject.summary is
'简述说明';

comment on column matrix_authorization_subject.state is
'状态';

/*==============================================================*/
/* Index: matrix_authorization_subject_pk                              */
/*==============================================================*/
create unique index matrix_authorization_subject_pk on matrix_authorization_subject (
subject_id
);

/*==============================================================*/
/* Table: matrix_authorization_subject_extended_column                 */
/*==============================================================*/
create table matrix_authorization_subject_extended_column (
   column_id            int8                 not null,
   subject_id           int8                 not null,
   column_name          varchar(36)          not null,
   column_value         varchar(200)         not null,
   column_comment       varchar(36)          not null,
   constraint pk_matrix_authorization_subject_exten primary key (column_id)
);

comment on table matrix_authorization_subject_extended_column is
'被授权主体扩展列';

comment on column matrix_authorization_subject_extended_column.column_id is
'pk';

comment on column matrix_authorization_subject_extended_column.subject_id is
'PrimaryKey';

comment on column matrix_authorization_subject_extended_column.column_name is
'列名';

comment on column matrix_authorization_subject_extended_column.column_value is
'列值';

comment on column matrix_authorization_subject_extended_column.column_comment is
'列注释';

/*==============================================================*/
/* Index: matrix_authorization_subject_extended_column_pk              */
/*==============================================================*/
create unique index matrix_authorization_subject_extended_column_pk on matrix_authorization_subject_extended_column (
column_id
);

/*==============================================================*/
/* Index: extended_column_fk                                    */
/*==============================================================*/
create  index extended_column_fk on matrix_authorization_subject_extended_column (
subject_id
);
