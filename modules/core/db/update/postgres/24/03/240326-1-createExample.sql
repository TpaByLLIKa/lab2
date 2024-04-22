create table LAB2_EXAMPLE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    str_prop varchar(255),
    big_dec_prop decimal(19, 2),
    --
    primary key (ID)
);