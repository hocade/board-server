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

create table USER_OPTION
(
    ID               bigint auto_increment,
    USER_ID          bigint       null,
    PUSH_TOKEN       varchar(100) null,
    LANGUAGE_CODE    varchar(50)  null,
    NOTICE           tinyint default false,
    CREATED_DATETIME datetime     null,
    UPDATED_DATETIME datetime     null,
    constraint USER_OPTION_pk
        primary key (ID),
    constraint USER_OPTION_USER_ID_fk
        foreign key (USER_ID) references USER (ID)
);

create table FRIENDSHIP
(
    ID               bigint auto_increment,
    USER_ID          bigint      null,
    FRIEND_ID        bigint      null,
    STATUS           varchar(50) null,
    CREATED_DATETIME datetime    null,
    UPDATED_DATETIME datetime    null,
    constraint FRIENDSHIP_pk
        primary key (ID),
    constraint FRIENDSHIP_USER_ID_fk
        foreign key (USER_ID) references USER (ID),
    constraint FRIENDSHIP_USER_ID_fk_2
        foreign key (FRIEND_ID) references USER (ID)
);


insert into ROLE (NAME, TYPE) values('ROLE_ADMIN', 'ROLE_ADMIN');
insert into ROLE (NAME, TYPE) values('ROLE_USER', 'ROLE_USER');

INSERT INTO ATTACHMENT (ID, EXT, UPLOAD_FILE_NAME, ORIGINAL_FILE_NAME, RESOURCE_URL, FULL_PATH, CREATED_DATETIME, UPDATED_DATETIME) VALUES (1, 'html', 'ad018561872b4efba5590b42293d1b03.html', 'test.html', 'https://hocade.s3.ap-northeast-2.amazonaws.com/ad018561872b4efba5590b42293d1b03.html', '/attachment/ad018561872b4efba5590b42293d1b03.html', '2024-05-24 05:04:43', '2024-05-24 05:04:43');
INSERT INTO TERMS (ID, TYPE, FILE_ID, CREATED_DATETIME, UPDATED_DATETIME, ORDINAL) VALUES (1, 'PRIVACY', 1, '2024-05-24 05:04:43', '2024-05-24 05:04:43', 0);
