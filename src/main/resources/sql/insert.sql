-- 创建序列  com_table_ctid_Seq 
create sequence com_table_ctid_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;
-- 创建序列  award_type_atid_Seq
create sequence award_type_atid_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;

-- 创建申请表的序列 application_id_Seq
create sequence application_id_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;

--DROP SEQUENCE application_id_Seq
--部门表
insert into dept values('1','软件工程','佚名1','18804539085');
insert into dept values('2','信息安全','佚名2','13982736473');
insert into dept values('3','研究生院办','佚名3','17768237238');
insert into dept values('4','学工办','佚名4','15180457236');
--delete from dept;

--班级表
--软件工程1701
--信息安全171
insert into class values('1701','软件工程1701班','1','2017级','赵盼盼','18146618512','班导1','班导1电话');
insert into class values('1702','软件工程1702班','1','2017级','赵盼盼','18146618512','班导2','班导2电话');
insert into class values('1703','软件工程1703班','1','2017级','赵盼盼','18146618512','班导3','班导3电话');
insert into class values('1704','软件工程1704班','1','2017级','赵盼盼','18146618512','班导4','班导4电话');
insert into class values('1705','软件工程1705班','1','2017级','赵盼盼','18146618512','班导5','班导5电话');
insert into class values('1706','软件工程1706班','1','2017级','赵盼盼','18146618512','班导6','班导6电话');
insert into class values('1707','软件工程1707班','1','2017级','熊伟','18146618512','班导7','班导7电话');
insert into class values('1708','软件工程1708班','1','2017级','熊伟','18146618512','班导8','班导8电话');
insert into class values('1709','软件工程1709班','1','2017级','佚名','18146618512','班导9','班导9电话');
insert into class values('1710','软件工程1710班','1','2017级','熊伟','18146618512','班导10','班导10电话');

insert into class values('171','信息安全1701班','2','2017级','辅导员1','18146618512','班导1','班导1电话');
insert into class values('172','信息安全1702班','2','2017级','辅导员2','18146618512','班导1','班导1电话');
insert into class values('173','信息安全1703班','2','2017级','辅导员3','18146618512','班导1','班导1电话');
insert into class values('174','信息安全1704班','2','2017级','辅导员4','18146618512','班导1','班导1电话');



--学生表
insert into student values('8002117247','牛坤滢','女',to_date('1999-07-19','YYYY-MM-DD'),'10#503','1706','nky','13546569607','0','6217****404');
--（这条方便你们登录）
insert into student values('111','王花花','女',to_date('1999-07-19','YYYY-MM-DD'),'10#503','1706','111','13546569607','0','6217****404');

--教师表
insert into teacher values('0001','贾晓娟','女',to_date('1987-01','YYYY-MM'),'4','教师1电话','讲师','0001','0','教师1卡号');
insert into teacher values('0002','钟红','女',to_date('1987-02','YYYY-MM'),'4','教师2电话','副教授','0002','0','教师2卡号');
insert into teacher values('0003','刘雪恩','女',to_date('1987-03','YYYY-MM'),'4','教师3电话','教授','0003','0','教师3卡号');
insert into teacher values('0004','刘晓芒','女',to_date('1967-04','YYYY-MM'),'4','教师4电话','教授','0004','1','教师4卡号');
insert into teacher values('0005','王媛媛','女',to_date('1987-05','YYYY-MM'),'4','教师5电话','助教','0005','0','教师5卡号');
insert into teacher values('0006','孙荣','男',to_date('1987-06','YYYY-MM'),'4','教师6电话','高工','0006','0','教师6卡号');

--管理员表
insert into administrator values('admin1001','hwj','黄文俊');
insert into administrator values('admin1002','zsr','赵思蓉');
insert into administrator values('admin1003','nky','牛坤滢');

--成果类型表
insert into result_type values('0','考试');
insert into result_type values('1','作品');

--级别类型表
insert into level_type values('0','国家级');
insert into level_type values('1','省级');

--所获奖项类型表
insert into prize_type values('1','特等奖');
insert into prize_type values('2','一等奖');
insert into prize_type values('3','二等奖');
insert into prize_type values('4','三等奖');
insert into prize_type values('5','优秀奖');

--select * from award_type;
--获奖类型表
--有奖金：
--（重点竞赛项目）
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','1',2000,2000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','2',1000,1000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','3',600,600);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','4',400,400);

insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','1',1000,800);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','2',800,600);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','3',600,400);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','4',400,200);

insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','1',3000,3000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','2',2000,2000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','3',1000,1000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','4',600,600);

insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','1',2000,2000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','2',1000,1000);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','3',800,800);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','4',600,600);

--（一般竞赛项目）
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','1',1000,1000);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','2',800,800);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','3',600,600);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','4',400,400);

insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','1',800,400);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','2',600,300);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','3',400,200);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','4',200,100);

insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','1',2000,2000);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','2',1000,1000);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','3',800,800);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','4',600,600);

insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','1',1000,500);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','2',800,400);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','3',600,300);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','4',400,200);

--无奖金
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','5',0,0);

insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','5',0,0);

--获奖项类型表
--备注 1 ：重点（A类） 0 ：一般
--备注 1：考试 0：作品
insert into com_table values(com_table_ctid_Seq.Nextval,'中国“互联网+”大学生创新创业大赛','教育部与相关部委','1A','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生“恩智浦”杯智能汽车竞赛','教育部高等学校自动化类教学指导委员会恩智浦（中国）管理有限公司','1A','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生电子设计竞赛','高等教育司工业与信息产业部','1A','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'计算机仿真大赛','教育部高教司委托全国计算机仿真大赛组委员会','1A','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ACM国际大学生编程竞赛','美国计算机协会','1A','1','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ASC世界大学生超级计算机竞赛','国际超级计算机大会组委会（ISC）国际高性能计算咨询委员会（HPC）','1A','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'“挑战杯”全国大学生课外学术科技作品竞赛','共青团中央中国科协教育部和全国学联举办地人民政府','1A','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'“挑战杯”中国大学生创业计划大赛','共青团中央中国科协教育部和全国学联举办地人民政府','1A','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'美国数学建模竞赛','美国数学及其应用联合会','1A','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'SOPC电子设计竞赛','全国大学生电子设计竞赛湖北赛区组委会美国ALTERA公司','1B','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生数学建模竞赛',' ','1B','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生机器人大赛 RoboMaster','共青团中央全国学联深圳市人民政府','1C','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国软件专业人才设计与开发大赛','工信部教育部和中国软件协会','1C','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生中国大学生服务外包创新创业大赛','中华人民共和国教育部中华人民共和国商务部','1C','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'“西门子杯”中国智能制造挑战赛（原全国大学生“西门子杯”工业自动化挑战赛）','教育部高等学校自动化类专业教学指导委员会西门子（中国）有限公司中国仿真学会','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'CCF大数据与计算智能大赛（CCF-BDCI）','中国计算机学会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'CCF大学生计算机系统与程序设计竞赛（CCF-CCSP）','中国计算机学会','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'护网杯-2019年网络安全防护赛暨首届工业互联网安全大赛','中国互联网协会中国信息通信研究院国家工业信息安全发展研究中心','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'江西省大学生计算机作品赛','泛珠三角各省计算机学会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'江西省大学生科技创新与职业技能竞赛','省教育厅省高等院校科技开发办公室','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'江西省教育系统网络安全技能大赛','中共江西省委教育工委江西省教育厅江西省国际关系研究中心','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'蓝桥杯全国软件和信息技术专业人才大赛','工业和信息化部人才交流中心教育部全国高等学校学生信息咨询就业指导中心联合举办','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生电子设计竞赛嵌入式系统专题邀请赛','高等教育司工业与信息产业部','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生人工智能创新大赛','中国高校科技成果教育会组委会中国高校（华南）科技成果转换中心广东省惠州市教育局和澳门智库管理研究学会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生物联网设计竞赛（TI杯）','教育部高等学校计算机类专业教学指导委员会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生信息安全铁人三项赛（简称铁人三项）','教育部学校规划建设发展中心中国信息安全测评中心','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国高校大数据应用创新大赛（BDIC）','教育部高等学校计算机类专业教学指导委员会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国高校云计算应用创新大赛','教育部科技发展中心','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国大学生VRAR开发大赛','VRCORE、上海交通大学联合举办','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国大学生程序设计竞赛（简称CCPC大赛）','高等学校国家级实验教学示范中心联席会中国大学生程序设计竞赛协会','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国大学生计算机设计大赛','中国高等教育学会、教育部高等学校计算机类专业教学指导委员会等','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国高校计算机大赛-大数据挑战赛','教育部高等学校计算机类专业教学指导委员会软件工程专业教学指导委员会计算机课程教学指导委员会全国高等学校计算机教育研究会','0','1','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国高校计算机大赛-团体程序设计赛（天梯赛）','教育部高等学校计算机类专业教学指导委员会软件工程专业教学指导委员会计算机课程教学指导委员会全国高等学校计算机教育研究会','0','1','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国高校计算机大赛-微信小程序应用开发赛','教育部高等学校计算机类专业教学指导委员会教育部高等学校大学软件工程专业教学指导委员会全国高等学校计算机教育研究会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国机器人大赛','教育部高等学校自动化教学指导委员会','0','0','参考文件2');
insert into com_table values(com_table_ctid_Seq.Nextval,'“发现杯”全国大学生互联网软件设计大奖赛','工业和信息化部教育与考试中心达内时代科技集团有限公司','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'“中国软件杯”大学生软件设计大赛','工业和信息化部教育部和江苏省人民政府','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'“华梦”全国大学生开源软件创意大赛','中国电科普华基础软件','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'“华为杯”中国大学生智能设计竞赛','中国人工智能学会教育部高等学校计算机类专业教学指导委员会','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'“儒乐杯”江西青年科技创新大赛','中共江西省委人才办共青团江西省委江西省人社厅江西省科技厅江西省工信委江西省科学院','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ACM-ICPC国际大学生程序设计竞赛','国际计算机协会','0','1','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'江西省大学生程序设计大赛','','0','1','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'江西省信息安全大赛','','0','1','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国“博创杯”设计大赛','教育部高等教育司下属教育部高等学校计算机类教学指导委员会','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生网络商务创新应用大赛','中国互联网协会','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国密码技术竞赛','中国密码学会','0','1','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国移动互联创新大赛','中国通信学会全国移动互联网产业孵化中心','0','0','参考文件3');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生智能汽车竞赛','教育部高等学校自动化专业教学指导分委员会','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生电子商务“创新、创意及创业”挑战赛','教育部高等学校电子商务专业教学指导委员会','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生工程训练综合能力竞赛','教育部高等教育司','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生创新创业训练计划年会展示','国家级大学生创新创业训练计划专家工作组','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生先进成图技术与产品信息建模创新大赛','教育部高等学校工程图学教学指导委员会中国图学学会制图技术专业委员会中国图学学会产品信息建模专业委员会','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国三维数字化创新设计大赛（大学生组）','大赛组委会国家制造业信息化培训中心','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'全国大学生市场调查与分析大赛','教育部高等学校统计学类专业教学指导委员会中国商业统计学会','0','0','参考文件1');
insert into com_table values(com_table_ctid_Seq.Nextval,'中国大学生计算机作品大赛','','0','0','参考文件1');


