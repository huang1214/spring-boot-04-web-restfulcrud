-- 创建部门表（软件工程、信息安全等）
create table dept(
    dno varchar2(2) primary key ,
    dname varchar2(30) not null ,
    dadmin varchar2(10) not null ,
    dtel varchar2(15) not null
);
comment on table dept is '部门表';
comment on column dept.dno is '部门编号';
comment on column dept.dname is '部门名称';
comment on column dept.dadmin is '部门主管';
comment on column dept.dtel is '部门主管电话';

-- 创建班级表
create table class(
    cno varchar2(4) primary key ,
    cname varchar2(20) not null ,
    dno varchar2(2) not null ,
    cgrade char(2) not null ,
    cadmin varchar2(10) not null ,
    cadmintel varchar2(15) ,
    cmaster varchar2(10) not null ,
    cmastertel varchar2(15),
    constraint class_dept_dno_fk
        foreign key (dno) references dept(dno)
);

comment on table class is '班级表';
comment on column class.cno is '班级编号';
comment on column class.cname is '班级名称';
comment on column class.dno is '班级所属部门号';
comment on column class.cgrade is '班级所属年级';
comment on column class.cadmin is '辅导员';
comment on column class.cadmintel is '辅导员电话';
comment on column class.cmaster is '班导';
comment on column class.cmastertel is '班导电话';


create table teacher
(
	tno varchar2(10)
		constraint teacher_pk
			primary key,
	tname varchar2(10) not null,
	tsex varchar2(2) not null,
	tbirthday date,
	dno varchar2(2)
		constraint teacher_dept_dno_fk
			references dept (dno),
	ttel varchar2(15),
	ttitle varchar2(10),
	tpwd varchar2(50),
	tstate char(1) default 0 not null,
	card_num varchar2(20)
)
/

comment on table teacher is '教师表'
/

comment on column teacher.tno is '教室编号'
/

comment on column teacher.tname is '教师名称'
/

comment on column teacher.tsex is '教师性别'
/

comment on column teacher.tbirthday is '教师出生年月日'
/

comment on column teacher.dno is '教师所属部门'
/

comment on column teacher.ttel is '教师电话'
/

comment on column teacher.ttitle is '教师职称'
/

comment on column teacher.tpwd is '密码'
/

comment on column teacher.tstate is '在校状态：
0表示在校，
1表示离校'
/
comment on  column teacher.card_num is '银行卡号';





-- 创建学生表
CREATE TABLE student(
    sno VARCHAR2(10) not NULL primary key ,
    sname VARCHAR2(10) not NULL,
    ssex VARCHAR2(2) not NULL,
    sbirthday date not null ,
    sdomitory varchar2(20) not null ,
    cno varchar2(4) not null ,
    spwd varchar2(50) not null ,
    stel varchar2(15) not null ,
    state char(1) default 0 not null ,
    card_num varchar2(20) not null,
    constraint FK_REFERENCE_CLASS foreign key (cno) references class(cno)
);

comment on table student is '学生表';
comment on column student.sno is '学生编号';
comment on column student.sname is '学生姓名';
comment on column student.ssex is '学生性别';
comment on column student.sbirthday is '学生出生年月';
comment on column student.sdomitory is '寝室号';
comment on column student.cno is '班级号';
comment on column student.spwd is '密码';
comment on column student.stel is '学生电话';
comment on column student.state is '学生状态：0表示在校，1表示离校';
comment on column student.card_num is '银行卡号';


--创建学科和科技竞赛目录表
create table com_table(
      ctid char(5),
      ctname varchar2(256)      not null,
      host_unit varchar2(256)   not null,
      com_type char(3)          not null,
      reference_paper varchar2(50),
      constraint PK_COM_TABLE primary key (ctid)
);
comment on table com_table is '学科和科技竞赛目录表';
comment on column com_table.ctid is '学科和科技竞赛编号';
comment on column com_table.ctname is '学科和科技竞赛名称';
comment on column com_table.host_unit is '主办单位';
comment on column com_table.com_type is '学科和科技竞赛分类(0:一般竞赛项目,1:重点竞赛项目)';
comment on column com_table.reference_paper is '参考文件';

--创建级别类型表
create table level_type(
   ltid char(1) not null,
   ltname varchar2(50) not null,
   constraint PK_LEVEL_TYPE primary key (ltid)
);
comment on table level_type is '级别类型表';
comment on column level_type.ltid is '级别类型编号';
comment on column level_type.ltname is '级别类型名称(省级,国家级)';

--创建成果类型表
create table result_type(
        rtid char(1) not null,
        rtname varchar2(50) not null,
        constraint PK_RESULT_TYPE primary key (rtid)
);
comment on table result_type is '成果类型表';
comment on column result_type.rtid is '成果类型编号';
comment on column result_type.rtname is '成果类型名称(考试,作品)';

----------------
--  通用区👆
----------------

----------------
--  核心业务区👇
----------------

-- 成果申报表
--drop table application;
--drop table application_succ;

create table application(
    appId varchar2(20) not null,
    comName varchar2(50) not null,
    comNum number not null,
    applicantId char(10) not null,
    teacher1Id char(10) ,
    teacher2Id char(10) ,
    unit varchar2(20) not null,
    leader varchar2(20),
    teamNum number,
    team varchar2(200),
    studentPrice number not null,
    teacherPrice number ,
    awardTypeId char(2) not null,
    awardDate date not null,
    applicantBankCard varchar2(20) not null,
    workName varchar2(50),
    workBriefIntro varchar2(200) not null,
    certificateImg blob not null,
    getAwardImg blob,
    highLight blob,
    status number default 0,
    constraint PK_APPLICATION_ID primary key (appid)
);
COMMENT ON TABLE application IS '申请表信息表';
COMMENT ON COLUMN application.appId IS '申请表编号，作为主键';
COMMENT ON COLUMN application.comName IS '比赛名称';
COMMENT ON COLUMN application.comNum IS '比赛届数（第几届）';
COMMENT ON COLUMN application.applicantId IS '申请人的学号,外键';
COMMENT ON COLUMN application.unit IS '参赛的第一单位';
COMMENT ON COLUMN application.teacher1Id IS '指导老师1的职工号，外键';
COMMENT ON COLUMN application.teacher2Id IS '指导老师2的职工号，外键';
COMMENT ON COLUMN application.leader IS '队长（学号_姓名）';
COMMENT ON COLUMN application.teamNum IS '团队人数';
COMMENT ON COLUMN application.team IS '团队成员（学号_姓名，学号_姓名。。。。。）';
COMMENT ON COLUMN application.studentPrice IS '学生奖励金额';
COMMENT ON COLUMN application.teacherPrice IS '老师奖励金额';
COMMENT ON COLUMN application.applicantBankCard IS '申请人的银行卡号';
COMMENT ON COLUMN application.awardDate IS '获奖年份';
COMMENT ON COLUMN application.awardTypeId IS '获奖类型编号，外键';
COMMENT ON COLUMN application.workName IS '参赛作品名称';
COMMENT ON COLUMN application.workBriefIntro IS '作品简介';
COMMENT ON COLUMN application.certificateImg IS '证书证明';
COMMENT ON COLUMN application.getAwardImg IS '领奖照片';
COMMENT ON COLUMN application.highLight IS '比赛花絮';
COMMENT ON COLUMN application.status IS '申请状态（0：未审核，1：审核未通过，2：审核通过，3：申请人确认审核通过，4：奖金发放，5：申请人确认收到奖励）';
-- 外键都没写也

-- 备案申请表
create table bill(
    bid varchar2(20) not null ,
    ctid char(5) not null ,
    cyear date not null ,
    clevel char(1) not null ,
    cdesc varchar2(100) not null ,
    groupleader varchar2(20) ,
    groupname varchar2(100) ,
    team varchar2(200) ,
    teacher1Id varchar2(10) ,
    teacher2Id varchar2(10) ,
    result_type char(1) not null ,
    work_name varchar2(100) ,
    preditfeedesc varchar2(250) not null ,
    predictfee number not null ,
    state char(1) default 0 not null ,
    attachfile blob,
    constraint PK_BILL_ID primary key (bid),
    constraint bill_com_table_ctid_fk foreign key (ctid) references com_table(ctid),
    constraint bill_student_sno_fk foreign key (groupleader) references student(sno),
    constraint bill_teacher_teacherid1_fk foreign key (teacher1Id) references teacher(tno),
    constraint bill_teacher_teacherid2_fk foreign key (teacher2Id) references teacher(tno)
);



comment on table bill is '备案申请表';
comment on column bill.bid is '备案编号，才有自增长序列';
comment on column bill.ctid is '竞赛信息编号 外键';
comment on column bill.cyear is '参赛年份';
comment on column bill.clevel is '级别类型编号（0省赛，1国赛）';
comment on column bill.cdesc is '竞赛描述';
comment on column bill.groupleader is '团队负责人 外键';
comment on column bill.groupname is '团队名称';
comment on column bill.team is '团队信息：学号_姓名,学号姓名';
comment on column bill.teacher1Id is '指导老师编号 外键';
comment on column bill.result_type is '成果类型：0考试，1作品';
comment on column bill.work_name is '参赛作品名，如果是作品型比赛，那就规定要输入该项';
comment on column bill.preditfeedesc is '预算描述';
comment on column bill.predictfee is '预算费用';
comment on column bill.state is '申请状态（0：未审核，1：审核未通过，2：审核通过）';
comment on column bill.attachfile is '照片附件';
