# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ORDERS (
  PRICE                     float,
  final_price               float)
;

create table airtel (
  id                        bigint auto_increment not null,
  phone_number              integer,
  first_name                varchar(255),
  last_name                 varchar(255),
  client                    varchar(255),
  amount                    integer,
  done_at                   datetime,
  constraint pk_airtel primary key (id))
;

create table store (
  id                        bigint auto_increment not null,
  amount                    integer,
  done_at                   datetime,
  constraint pk_store primary key (id))
;

create table login (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_login primary key (email))
;

create table mtn (
  id                        bigint auto_increment not null,
  phone_number              integer,
  first_name                varchar(255),
  last_name                 varchar(255),
  client                    varchar(255),
  amount                    integer,
  done_at                   datetime,
  constraint pk_mtn primary key (id))
;

create table power_data (
  id                        bigint auto_increment not null,
  meter_number              integer,
  customer_names            varchar(255),
  amount                    integer,
  done_at                   datetime,
  constraint pk_power_data primary key (id))
;

create table users (
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  type                      varchar(255),
  done_at                   datetime)
;

create table tigo (
  id                        bigint auto_increment not null,
  phone_number              integer,
  first_name                varchar(255),
  last_name                 varchar(255),
  client                    varchar(255),
  amount                    integer,
  done_at                   datetime,
  constraint pk_tigo primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ORDERS;

drop table airtel;

drop table store;

drop table login;

drop table mtn;

drop table power_data;

drop table users;

drop table tigo;

SET FOREIGN_KEY_CHECKS=1;

