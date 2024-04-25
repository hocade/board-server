create table USER
(
    ID                    bigint auto_increment
        primary key,
    NICK_NAME             varchar(50)  null,
    PASSWORD              varchar(100) null,
    EMAIL                 varchar(50)  null,
    PHONE_COUNTRY_CODE    varchar(50)  null,
    PHONE_NATIONAL_NUMBER varchar(50)  null,
    UNIQUE_CODE           varchar(50)  null,
    CREATED_DATETIME      datetime     null,
    UPDATED_DATETIME      datetime     null,
    STATUS                varchar(50)  null,
    PROFILE_ID            bigint       null
);


create table ROLE
(
    ID   bigint auto_increment
        primary key,
    NAME varchar(50) not null,
    TYPE varchar(50) not null
);

create table USER_ROLES
(
    USER_ID bigint null,
    ROLE_ID bigint null,
    constraint USER_ROLES_ROLE_ID_fk
        foreign key (ROLE_ID) references ROLE (ID),
    constraint USER_ROLES_USER_ID_fk
        foreign key (USER_ID) references USER (ID)
);


create table TERMS
(
    ID               bigint(11) auto_increment,
    TYPE             varchar(50) null,
    FILE_ID          bigint(11)  null,
    CREATED_DATETIME datetime    null,
    UPDATED_DATETIME datetime    null,
    ORDINAL          bigint(11)  null,
    constraint TERMS_pk
        primary key (ID)
);


create table USER_TERMS
(
    USER_ID          bigint   not null,
    TERMS_ID         bigint   not null,
    CREATED_DATETIME datetime null,
    UPDATED_DATETIME datetime null,
    constraint USER_TERMS_pk
        primary key (USER_ID, TERMS_ID)
);

create table ATTACHMENT
(
    ID                 bigint(11) auto_increment,
    EXT                varchar(50)  null,
    UPLOAD_FILE_NAME   varchar(100) null,
    ORIGINAL_FILE_NAME varchar(100) null,
    RESOURCE_URL       varchar(200) null,
    FULL_PATH          varchar(50)  null,
    CREATED_DATETIME   datetime     null,
    UPDATED_DATETIME   datetime     null,
    constraint ATTACHMENT_pk
        primary key (ID)
);