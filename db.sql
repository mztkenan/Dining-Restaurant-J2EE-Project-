create table test(
userid varchar(20) primary key,
username varchar(20),
password varchar(20)
);
insert into test values(1,"zhangsan",123);
insert into test values(2,"lisi",12);
insert into test values(3,"wangwu",123);

create database myf ;
use myf;

create table test(
userid varchar(20),
username varchar(20),
password varchar(20)
);

select * from test;

use sys;
create table student(
stuid varchar(20),
stuname varchar(20),
age int,
gender varchar(20),
birthday date,
address varchar(30)
);

select * from sys.student;

insert into student values("001","zhangsan",18,"male","1996/01/01","cugb");
insert into student values("002","wangbing",17,"female","1996/01/01","cugb");
insert into student values("002","章斌斌",17,"female","1996/01/01","cugb");


create table aaa(
aaa varchar(20) key
);

create table bbb(
bbb varchar(20),
stuid varchar(20) ,
 foreign key(stuid) references aaa(aaa) 
);



insert into user values('1','Bob','123456','1');
insert into user values('2','Beyond','123456','1');
insert into user values('3','BinBin','123456','2');

insert into product values('1','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/500047.jpg');
insert into product values('2','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/500046.jpg');
insert into product values('3','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/500044.jpg');

insert into orderInfomation values('1','1','北京海淀区学院路29号中国地质大学学19楼0422','13756481964','2017-05-16 09:45:07','3.99','unpay','不要酱瓜');

insert into orderItem values('1','1','1','1','1.99');
insert into orderItem values('2','1','2','2','2.00');

