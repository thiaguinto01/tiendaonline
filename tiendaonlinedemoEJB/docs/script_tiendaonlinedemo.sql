/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     11/8/2021 19:22:06                           */
/*==============================================================*/


drop index CLI_PAG_FK;

drop index CLI_CONTAC_FK;

drop index CLI_CLIDIRE_FK;

drop index CLI_CLIENTE_PK;

drop table CLI_CLIENTE;

drop index CLI_CONTACTO_PK;

drop table CLI_CONTACTO;

drop index CLI_DIRECCION_PK;

drop table CLI_DIRECCION;

drop index CLI_PAGO_PK;

drop table CLI_PAGO;

drop index INV_COLOR_PK;

drop table INV_COLOR;

drop index INV_MARCA_PK;

drop table INV_MARCA;

drop index RELATIONSHIP_4_FK;

drop index RELATIONSHIP_3_FK;

drop index RELATIONSHIP_2_FK;

drop index PRO_TIPO_FK;

drop index INV_PRODUCTO_PK;

drop table INV_PRODUCTO;

drop index INV_TALLA_PK;

drop table INV_TALLA;

drop index INV_TIPO_PRODUCTO_PK;

drop table INV_TIPO_PRODUCTO;

drop index RELATIONSHIP_8_FK;

drop index VEN_CABECERA_PK;

drop table VEN_CABECERA;

drop index RELATIONSHIP_6_FK;

drop index DETVEN_PRO_FK;

drop index VEN_DETALLE_PK;

drop table VEN_DETALLE;

/*==============================================================*/
/* Table: CLI_CLIENTE                                           */
/*==============================================================*/
create table CLI_CLIENTE (
   ID_CLIENTE           SERIAL               not null,
   ID_DIRECCION         INT4                 null,
   ID_NUM_TELEFONO      INT4                 null,
   ID_PAGO              INT4                 null,
   CLI_CEDULA           VARCHAR(10)          not null,
   CLI_NOMBRE           VARCHAR(30)          not null,
   CLI_CORREO           VARCHAR(50)          not null,
   CLI_ACTIVO           BOOL                 not null,
   constraint PK_CLI_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLI_CLIENTE_PK                                        */
/*==============================================================*/
create unique index CLI_CLIENTE_PK on CLI_CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Index: CLI_CLIDIRE_FK                                        */
/*==============================================================*/
create  index CLI_CLIDIRE_FK on CLI_CLIENTE (
ID_DIRECCION
);

/*==============================================================*/
/* Index: CLI_CONTAC_FK                                         */
/*==============================================================*/
create  index CLI_CONTAC_FK on CLI_CLIENTE (
ID_NUM_TELEFONO
);

/*==============================================================*/
/* Index: CLI_PAG_FK                                            */
/*==============================================================*/
create  index CLI_PAG_FK on CLI_CLIENTE (
ID_PAGO
);

/*==============================================================*/
/* Table: CLI_CONTACTO                                          */
/*==============================================================*/
create table CLI_CONTACTO (
   ID_NUM_TELEFONO      SERIAL               not null,
   NUM_CELULAR          VARCHAR(10)          null,
   NUM_CONVENCIONAL     VARCHAR(9)           null,
   constraint PK_CLI_CONTACTO primary key (ID_NUM_TELEFONO)
);

/*==============================================================*/
/* Index: CLI_CONTACTO_PK                                       */
/*==============================================================*/
create unique index CLI_CONTACTO_PK on CLI_CONTACTO (
ID_NUM_TELEFONO
);

/*==============================================================*/
/* Table: CLI_DIRECCION                                         */
/*==============================================================*/
create table CLI_DIRECCION (
   ID_DIRECCION         SERIAL               not null,
   DIREC_CALLE_PRINCIPAL VARCHAR(60)          not null,
   DIREC_CALLE_SECUNDARIA VARCHAR(60)          not null,
   DIREC_NUMERO         INT4                 not null,
   constraint PK_CLI_DIRECCION primary key (ID_DIRECCION)
);

/*==============================================================*/
/* Index: CLI_DIRECCION_PK                                      */
/*==============================================================*/
create unique index CLI_DIRECCION_PK on CLI_DIRECCION (
ID_DIRECCION
);

/*==============================================================*/
/* Table: CLI_PAGO                                              */
/*==============================================================*/
create table CLI_PAGO (
   ID_PAGO              SERIAL               not null,
   PAG_TIPO             VARCHAR(20)          not null,
   constraint PK_CLI_PAGO primary key (ID_PAGO)
);

/*==============================================================*/
/* Index: CLI_PAGO_PK                                           */
/*==============================================================*/
create unique index CLI_PAGO_PK on CLI_PAGO (
ID_PAGO
);

/*==============================================================*/
/* Table: INV_COLOR                                             */
/*==============================================================*/
create table INV_COLOR (
   ID_COLOR             SERIAL               not null,
   COL_NOMBRE           VARCHAR(30)          not null,
   constraint PK_INV_COLOR primary key (ID_COLOR)
);

/*==============================================================*/
/* Index: INV_COLOR_PK                                          */
/*==============================================================*/
create unique index INV_COLOR_PK on INV_COLOR (
ID_COLOR
);

/*==============================================================*/
/* Table: INV_MARCA                                             */
/*==============================================================*/
create table INV_MARCA (
   ID_MARCA             SERIAL               not null,
   MAR_NOMBRE           VARCHAR(20)          not null,
   constraint PK_INV_MARCA primary key (ID_MARCA)
);

/*==============================================================*/
/* Index: INV_MARCA_PK                                          */
/*==============================================================*/
create unique index INV_MARCA_PK on INV_MARCA (
ID_MARCA
);

/*==============================================================*/
/* Table: INV_PRODUCTO                                          */
/*==============================================================*/
create table INV_PRODUCTO (
   ID_PRODUCTO          SERIAL               not null,
   ID_MARCA             INT4                 null,
   ID_COLOR             INT4                 null,
   ID_TALLA             INT4                 null,
   ID_TIPO_PRODUCTO     INT4                 null,
   PRO_PRECIO           FLOAT8               not null,
   PRO_STOCK            INT4                 not null,
   constraint PK_INV_PRODUCTO primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Index: INV_PRODUCTO_PK                                       */
/*==============================================================*/
create unique index INV_PRODUCTO_PK on INV_PRODUCTO (
ID_PRODUCTO
);

/*==============================================================*/
/* Index: PRO_TIPO_FK                                           */
/*==============================================================*/
create  index PRO_TIPO_FK on INV_PRODUCTO (
ID_TIPO_PRODUCTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on INV_PRODUCTO (
ID_MARCA
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on INV_PRODUCTO (
ID_COLOR
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on INV_PRODUCTO (
ID_TALLA
);

/*==============================================================*/
/* Table: INV_TALLA                                             */
/*==============================================================*/
create table INV_TALLA (
   ID_TALLA             SERIAL               not null,
   TALL_DESCRIPCION     VARCHAR(20)          not null,
   constraint PK_INV_TALLA primary key (ID_TALLA)
);

/*==============================================================*/
/* Index: INV_TALLA_PK                                          */
/*==============================================================*/
create unique index INV_TALLA_PK on INV_TALLA (
ID_TALLA
);

/*==============================================================*/
/* Table: INV_TIPO_PRODUCTO                                     */
/*==============================================================*/
create table INV_TIPO_PRODUCTO (
   ID_TIPO_PRODUCTO     SERIAL               not null,
   TIPO_DESCRIPCION     VARCHAR(40)          not null,
   constraint PK_INV_TIPO_PRODUCTO primary key (ID_TIPO_PRODUCTO)
);

/*==============================================================*/
/* Index: INV_TIPO_PRODUCTO_PK                                  */
/*==============================================================*/
create unique index INV_TIPO_PRODUCTO_PK on INV_TIPO_PRODUCTO (
ID_TIPO_PRODUCTO
);

/*==============================================================*/
/* Table: VEN_CABECERA                                          */
/*==============================================================*/
create table VEN_CABECERA (
   ID_VEN_CABECERA      SERIAL               not null,
   ID_CLIENTE           INT4                 null,
   VEN_CAB_FECHA        DATE                 not null,
   VEN_CAB_IVA          numeric(7,2)               not null,
   VEN_CAB_TOTAL        numeric(7,2)               not null,
   constraint PK_VEN_CABECERA primary key (ID_VEN_CABECERA)
);

/*==============================================================*/
/* Index: VEN_CABECERA_PK                                       */
/*==============================================================*/
create unique index VEN_CABECERA_PK on VEN_CABECERA (
ID_VEN_CABECERA
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on VEN_CABECERA (
ID_CLIENTE
);

/*==============================================================*/
/* Table: VEN_DETALLE                                           */
/*==============================================================*/
create table VEN_DETALLE (
   ID_VEN_DETALLE       SERIAL               not null,
   ID_VEN_CABECERA      INT4                 null,
   ID_PRODUCTO          INT4                 null,
   VEN_DET_CANTIDAD     INT4                 not null,
   VEN_DET_PRECIO       FLOAT8               not null,
   constraint PK_VEN_DETALLE primary key (ID_VEN_DETALLE)
);

/*==============================================================*/
/* Index: VEN_DETALLE_PK                                        */
/*==============================================================*/
create unique index VEN_DETALLE_PK on VEN_DETALLE (
ID_VEN_DETALLE
);

/*==============================================================*/
/* Index: DETVEN_PRO_FK                                         */
/*==============================================================*/
create  index DETVEN_PRO_FK on VEN_DETALLE (
ID_PRODUCTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on VEN_DETALLE (
ID_VEN_CABECERA
);

alter table CLI_CLIENTE
   add constraint FK_CLI_CLIE_CLI_CLIDI_CLI_DIRE foreign key (ID_DIRECCION)
      references CLI_DIRECCION (ID_DIRECCION)
      on delete restrict on update restrict;

alter table CLI_CLIENTE
   add constraint FK_CLI_CLIE_CLI_CONTA_CLI_CONT foreign key (ID_NUM_TELEFONO)
      references CLI_CONTACTO (ID_NUM_TELEFONO)
      on delete restrict on update restrict;

alter table CLI_CLIENTE
   add constraint FK_CLI_CLIE_CLI_PAG_CLI_PAGO foreign key (ID_PAGO)
      references CLI_PAGO (ID_PAGO)
      on delete restrict on update restrict;

alter table INV_PRODUCTO
   add constraint FK_INV_PROD_PRO_TIPO_INV_TIPO foreign key (ID_TIPO_PRODUCTO)
      references INV_TIPO_PRODUCTO (ID_TIPO_PRODUCTO)
      on delete restrict on update restrict;

alter table INV_PRODUCTO
   add constraint FK_INV_PROD_RELATIONS_INV_MARC foreign key (ID_MARCA)
      references INV_MARCA (ID_MARCA)
      on delete restrict on update restrict;

alter table INV_PRODUCTO
   add constraint FK_INV_PROD_RELATIONS_INV_COLO foreign key (ID_COLOR)
      references INV_COLOR (ID_COLOR)
      on delete restrict on update restrict;

alter table INV_PRODUCTO
   add constraint FK_INV_PROD_RELATIONS_INV_TALL foreign key (ID_TALLA)
      references INV_TALLA (ID_TALLA)
      on delete restrict on update restrict;

alter table VEN_CABECERA
   add constraint FK_VEN_CABE_RELATIONS_CLI_CLIE foreign key (ID_CLIENTE)
      references CLI_CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

alter table VEN_DETALLE
   add constraint FK_VEN_DETA_DETVEN_PR_INV_PROD foreign key (ID_PRODUCTO)
      references INV_PRODUCTO (ID_PRODUCTO)
      on delete restrict on update restrict;

alter table VEN_DETALLE
   add constraint FK_VEN_DETA_RELATIONS_VEN_CABE foreign key (ID_VEN_CABECERA)
      references VEN_CABECERA (ID_VEN_CABECERA)
      on delete restrict on update restrict;

