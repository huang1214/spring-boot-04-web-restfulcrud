--以下是触发器测试语句
select * from application;
--delete from application;

----测试第四条 
--（四）师生所有奖励在同一年度同一竞赛中按就高原则，不重复计算（有规定的除外）。
--4.1.负责人的就高
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','1000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0003','0004','南昌大学软件学院','NA',0,'NA','2000','600','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
--4.2.指导老师的就高
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','1000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'111','0001','0002','南昌大学软件学院','NA',0,'NA','800','1600','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);

--测试第五条 
--（五）5.1每位负责人单次竞赛获得奖金不超过3000元
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3100','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);

--5.2 学年累积奖金不超过20000元。
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国大学生电子设计竞赛',14,'8002117247','0003','0004','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-12','YYYY-MM'),'6217*0040','杭州舒跑网络技术有限公司','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'计算机仿真大赛',15,'8002117247','0005','0006','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-02','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国三维数字化创新设计大赛（大学生组）',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-05','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国移动互联创新大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-06','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国密码技术竞赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'中国大学生计算机作品大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
--测试第六条
--6.1每位指导老师（项目第一指导老师）单次竞赛（同一项目指导多个学生、多个作品只取最好成绩计算）
insert into application values(award_type_atid_Seq.Nextval,'中国大学生计算机作品大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','3000','800','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'中国大学生计算机作品大赛',13,'111','0001','0002','南昌大学软件学院','NA',0,'NA','3000','1000','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
--6.2单次竞赛获得奖金不超过3000元，
insert into application values(award_type_atid_Seq.Nextval,'中国大学生计算机作品大赛',13,'111','0001','0002','南昌大学软件学院','NA',0,'NA','3000','4000','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
--6.3学年累积奖金不超过20000元。
insert into application values(award_type_atid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','0','3000','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国大学生电子设计竞赛',14,'8002117247','0001','0004','南昌大学软件学院','NA',0,'NA','0 ','3000','59',to_date('2018-12','YYYY-MM'),'6217*0040','杭州舒跑网络技术有限公司','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'计算机仿真大赛',15,'8002117247','0001','0001','南昌大学软件学院','NA',0,'NA','0 ','3000','59',to_date('2018-02','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国三维数字化创新设计大赛（大学生组）',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','0','3000','59',to_date('2018-05','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国移动互联创新大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','0','3000','59',to_date('2018-06','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'全国密码技术竞赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','0','3000','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
insert into application values(award_type_atid_Seq.Nextval,'中国大学生计算机作品大赛',13,'8002117247','0001','0002','南昌大学软件学院','NA',0,'NA','0','3000','59',to_date('2018-07','YYYY-MM'),'6217*0040','微智云校园','作品简介',utl_raw.cast_to_raw('证书证明'), utl_raw.cast_to_raw('领奖照片'),utl_raw.cast_to_raw('比赛花絮'),0);
select * from application;
