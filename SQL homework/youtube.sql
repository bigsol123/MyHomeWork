select table_name from user_tables;
insert into youtube(title, channelname,uploaddate, views,good) values 
('우당탕탕 일본여행','빠니보통',to_date('2024-10-04','YYYY-MM-DD'),1234,1234);
insert into youtube(title, channelname,uploaddate, views,good) values 
('우당탕탕 폴란드여행','꽉튜브',to_date('2023-10-02','YYYY-MM-DD'),15125,1514);
insert into youtube(title, channelname,uploaddate, views,good) values 
('우당탕탕 헝가리여행','서지로36',to_date('2022-09-09','YYYY-MM-DD'),1611,124);
select * from youtube;
commit;
select * from youtube;