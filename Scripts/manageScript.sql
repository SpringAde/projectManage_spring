create table project(
   id int(40) primary key auto_increment,
   title varchar(50),
   content text,
   startdate date,
   enddate date,
   state varchar(10)
);

insert into project(title, content, startdate, enddate, state) values('여행 프로젝트','꺅! 신남 신남!','2016-01-12','2017-12-12','종료');
insert into project(title, content, startdate, enddate, state) values('카페 프로젝트','시원한 아메리카노','2017-03-12','2017-10-10','진행중');
insert into project(title, content, startdate, enddate, state) values('빵집 프로젝트','소세지빵 주세효!','2017-06-11','2017-11-12','진행중');


select * from project;
drop table project;

