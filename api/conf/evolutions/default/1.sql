# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table mevlut (
  id                            bigserial not null,
  name                          varchar(255) not null,
  description                   varchar(255) not null,
  position_id                   bigint,
  updated_at                    timestamptz not null,
  created_at                    timestamptz not null,
  constraint uq_mevlut_position_id unique (position_id),
  constraint pk_mevlut primary key (id)
);

create table position (
  id                            bigserial not null,
  latitude                      float not null,
  longitude                     float not null,
  updated_at                    timestamptz not null,
  created_at                    timestamptz not null,
  constraint pk_position primary key (id)
);

alter table mevlut add constraint fk_mevlut_position_id foreign key (position_id) references position (id) on delete restrict on update restrict;


# --- !Downs

alter table if exists mevlut drop constraint if exists fk_mevlut_position_id;

drop table if exists mevlut cascade;

drop table if exists position cascade;

