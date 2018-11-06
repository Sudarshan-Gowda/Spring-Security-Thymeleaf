-- Create table
create table STAR_SM_USER
(
  star_id       NUMBER(19) not null,
  user_name     VARCHAR2(100),
  user_password VARCHAR2(100),
  is_enabled    NUMBER(1),
  status        VARCHAR2(100)
);

-- Create table
create table STAR_SM_USER_ROLE
(
  star_id          NUMBER(19) not null,
  role_name        VARCHAR2(100),
  role_description VARCHAR2(100)
);

-- Insert scripts for user table --
insert into star_sm_user (STAR_ID, USER_NAME, USER_PASSWORD, IS_ENABLED, STATUS)
values (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1, 'ACTIVE');


