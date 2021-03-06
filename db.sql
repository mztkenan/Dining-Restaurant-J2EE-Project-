/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/16 8:56:56                            */
/*==============================================================*/


drop table if exists orderInfomation;

drop table if exists orderItem;

drop table if exists product;

drop table if exists user;

use sys;
/*==============================================================*/
/* Table: orderInfomation                                       */
/*==============================================================*/
create table orderInfomation
(
   orderId              varchar(50) not null,
   userId               varchar(50),
   orderAddress         varchar(100) not null,
   orderPhone           varchar(15) not null,
   orderDate            datetime not null,
   orderPrice           float not null,
   orderState           varchar(50) not null,
   orderRemark          varchar(50),
   primary key (orderId)
);

/*==============================================================*/
/* Table: orderItem                                             */
/*==============================================================*/
create table orderItem
(
   productId            varchar(50) not null,
   orderId              varchar(50) not null,
   orderItemId          varchar(50) not null,
   productNum           int not null,
   orderItemSubtotal    float not null,
   primary key (productId, orderId)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   productId            varchar(50) not null,
   productName          varchar(100) not null,
   productPrice         float not null,
   productRemained       int not null,
   productDescription   varchar(200),
   productImage          varchar(100),
   primary key (productId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userId               varchar(50) not null,
   username             varchar(50) not null,
   password             varchar(50) not null,
   userType             int not null,
   primary key (userId)
);

alter table orderInfomation add constraint FK_Relationship_1 foreign key (userId)
      references user (userId) on delete CASCADE on update CASCADE;

alter table orderItem add constraint FK_orderItem foreign key (productId)
      references product (productId) on delete CASCADE on update CASCADE;

alter table orderItem add constraint FK_orderItem2 foreign key (orderId)
      references orderInfomation (orderId) on delete CASCADE on update CASCADE;





insert into user values('1','Bob','123456','1');
insert into user values('2','Beyond','123456','1');
insert into user values('3','BinBin','123456','2');



insert into orderInfomation values('1','1','北京海淀区学院路29号中国地质大学学19楼0422','13756481964','2017-05-16 09:45:07','3.99','unpay','不要酱瓜');

insert into orderItem values('1','1','1','1','1.99');
insert into orderItem values('2','1','2','2','2.00');



