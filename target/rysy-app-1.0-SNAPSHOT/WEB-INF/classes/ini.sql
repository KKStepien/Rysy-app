CREATE TABLE "User"
(
  user_id      serial primary key,
  name         varchar(50) not null,
  surname      varchar(50) not null,
  login        varchar(50) not null,
  password     varchar(50) not null,
  birth_date   date        not null,
  email        varchar(50) not null,
  created_date date        not null
);

CREATE TABLE Moderator
(
  moderator_id  serial primary key,
  name          varchar(50) not null,
  surname       varchar(50) not null,
  city          varchar(50) not null,
  street        varchar(50),
  street_number varchar(5)  not null,
  local_number  varchar(5),
  postcode      char(6)     not null,
  pesel         char(11)    not null,
  phone_number  varchar(12) not null,
  login         varchar(50) not null,
  password      varchar(50) not null,
  birth_date    date        not null,
  email         varchar(50) not null,
  created_date  date        not null
);

CREATE TABLE Entry
(
  entry_id     serial primary key,
  description   text    not null,
  latitude     decimal not null,
  longitude    decimal not null,
  created_date date    not null,
  user_id      bigint references "User" (user_id)
);

CREATE TABLE Trail
(
  trail_id     serial primary key,
  distance     decimal not null,
  created_date date    not null,
  moderator_id bigint references Moderator (moderator_id)
);

CREATE TABLE Trail_Part
(
  trail_part_id   serial primary key,
  latitude_start  decimal not null,
  longitude_start decimal not null,
  latitude_end    decimal not null,
  longitude_end   decimal not null,
  trail_id        bigint references Trail (trail_id)
);

CREATE TABLE User_Trail
(
  user_trail_id serial primary key,
  name          varchar(100) not null,
  distance      decimal      not null,
  created_date  date         not null,
  user_id       bigint references "User" (user_id)
);

CREATE TABLE User_Trail_Part
(
  user_trail_part_id serial primary key,
  trail_id           bigint references Trail (trail_id),
  user_trail_id      bigint references User_Trail (user_trail_id)
);

CREATE TABLE Object
(
  object_id    serial primary key,
  name         varchar(100) not null,
  latitude     decimal      not null,
  longitude    decimal      not null,
  created_date date         not null,
  user_id      bigint references "User" (user_id)
);

INSERT INTO "User" (name, surname, login, password, birth_date, email, created_date) VALUES
('Lily', 'Evans', 'levns', 'ruda','01.31.1988', 'lily@gmail.com', '07.04.2019'),
('James', 'Potter', 'Rogacz', 'lily', '01.02.1988', 'james@gmail,com','07.04.2019');


INSERT INTO Object (name, latitude, longitude, created_date, user_id) VALUES
('Chatka Puchatka', '23.556', '45.456', '07.04.2019','1'),
('Murowaniec', '43.556', '34.456', '07.04.2019','2'),
('Wiata', '53.556', '45.456', '07.04.2019','1');


INSERT INTO Moderator
(name, surname, city, street, street_number, local_number,
 postcode, pesel, phone_number, login, password, birth_date, email, created_date) VALUES
('Syriusz', 'Black','London','Bakery','12','','03-332','88091223456','609709809',
 'łapa','pies','12.09.1988','black@gmail.com','07.04.2019'),
('Remus','Lupin','London','Hdsfds','12','12c','23-445','88070534567','345678907',
 'Lunatyk','Dfg6542fsg3','12.09.1988','remus@gmail.com','07.04.2019');

INSERT INTO Entry
(description, latitude, longitude, created_date, user_id) VALUES
('Śnieg na 5 metrów.".','5.645','43.435','07.06.2019','1'),
('Widziano misia.','34.567','56.346','09.06.2019','2'),
('Lampa.','34.567','45.657','09.09.2019','1');

INSERT INTO Trail
(distance, created_date, moderator_id) VALUES
('23','07.06.2019','1'),
('29','07.06.2019','2');

INSERT INTO  Trail_Part
(latitude_start, longitude_start, latitude_end, longitude_end,trail_id) VALUES
('23.456', '23.901','24.5645','24.079','1');

INSERT INTO User_Trail
(name, distance, created_date, user_id) VALUES
('moja','345','07.07.2019','1');

INSERT INTO User_Trail_Part
(trail_id, user_trail_id) VALUES
('1','1'),
('2','1');





