use sys;
insert into product values('1','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/1.jpg');
insert into product values('2','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/2.jpg');
insert into product values('3','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/9.jpg');
insert into product values('4','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/3.jpg');
insert into product values('5','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/4.jpg');
insert into product values('6','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/5.jpg');
insert into product values('7','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/6.jpg');
insert into product values('8','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/7.jpg');
insert into product values('9','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/8.jpg');
insert into product values('10','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/9.jpg');
insert into product values('11','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/1.jpg');
insert into product values('12','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/2.jpg');
insert into product values('13','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/9.jpg');
insert into product values('14','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/4.jpg');
insert into product values('15','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/5.jpg');
insert into product values('16','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/6.jpg');
insert into product values('17','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/7.jpg');
insert into product values('18','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/8.jpg');
insert into product values('19','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/9.jpg');
insert into product values('20','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/1.jpg');
insert into product values('21','咸菜','1.99','999','新鲜的咸菜，有萝卜丝、榨菜丝、酱瓜等。美味可口，过饭必备。','images/1.jpg');
insert into product values('22','米饭','1.00','999','白嫩可口的新鲜白米饭，火候地道，颗粒饱满。一份100g','images/2.jpg');
insert into product values('23','餐具','2.50','999','一份快捷餐具，包含筷子、勺子、纸巾、牙签、湿巾。','images/9.jpg');

select count(*) from product;

select * from product;
select * from user;
use sys;

select productid ProductId,productname ProductName,productImage ProductImage,productPrice  ProductPrice,productDescription ProductDescription from product limit 1,6;

drop table orderitem;
drop table orderinfomation;
drop table product;
drop table user;

update product set productImage='images/5.jpg' where productImage='images/5jpg';



