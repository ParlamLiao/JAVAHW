drop table if exists student;
drop table if exists landlord;
drop table if exists house;
drop table if exists hs_stu;
drop table if exists landlordbill;
create table student (
  studentid int identity(1,1),
  name varchar(25) not null,
  password varchar(25)  not null,
  phonenumber varchar(25) not null,
  location varchar(50) not null,
  birthday varchar(25) not null,
  sex varchar(25) not null
);

create table landlord (
  landlordid int identity(1,1),
  name varchar(25) not null,
  password varchar(25)  not null,
  phonenumber varchar(25) not null,
  location varchar(50) not null,
);

create table house (
  houseid int identity(1,1),
  ownerid int(25) not null,
  location varchar(50) not null,
  roomtype varchar(25) not null,
  size int(25) not null,
  rent int not null,
  sold int not null,
  foreign key(ownerid) references landlord(landlordid)
);
create table hs_stu (
  Hs_Stu_id int identity(1,1),
  houseid int not null,
  tenantid int not null,
  ownerid int not null,
  meetingPlace varchar(50) not null,
    meetingTime varchar(50) not null,
  foreign key(houseid) references house(houseid),
  foreign key(tenantid) references student(studentid),
  foreign key(ownerid) references landlord(landlordid)
);

create table landlordbill (
  id int identity(1,1),
  price int not null,
 landlordid int not null,
 postedtime varchar(50) not null,
 category varchar(50) not null,
  foreign key(landlordid) references landlord(landlordid)
);