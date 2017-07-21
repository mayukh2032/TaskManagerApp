# TaskManagerApp


create database taskmanager;
use taskmanager;

create table task_list
(
 task_id int not null auto_increment,
 task_name varchar(100) not null,
 task_description text,
 task_priority varchar(20),
 task_status varchar(20),
 task_start_time  TIMESTAMP not null, 
 task_end_time TIMESTAMP not null,
 task_archived bool default false,
 primary key(task_id)
 );
 
insert into task_list values(1,'Gathering Requirement','Requirement Gathering','MEDIUM','ACTIVE',curdate(),curdate() + INTERVAL 3 HOUR,0);
insert into task_list values(2,'Application Designing','Application Designing','MEDIUM','ACTIVE',curdate(),curdate() + INTERVAL 2 HOUR,0);
insert into task_list values(3,'Implementation','Implementation','MEDIUM','ACTIVE',curdate(),curdate() + INTERVAL 3 HOUR,0);
insert into task_list values(4,'Unit Testing','Unit Testing','LOW','ACTIVE',curdate(),curdate() + INTERVAL 4 HOUR,0);
insert into task_list values(5,'Maintanence','Maintanence','LOW','ACTIVE',curdate(),curdate() + INTERVAL 5 HOUR,0);
select * from task_list;
