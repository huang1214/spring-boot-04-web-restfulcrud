-- ��������  com_table_ctid_Seq 
create sequence com_table_ctid_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;
-- ��������  award_type_atid_Seq
create sequence award_type_atid_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;

-- �������������� application_id_Seq
create sequence application_id_Seq
increment by 1
start with 1
minvalue 1
maxvalue 999999999;

-- �������ű������ dept_dno_Seq
create sequence dept_dno_Seq
  increment by 1
  start with 1
  minvalue 1
  maxvalue 999999999;

-- ������ʦ������� teacher_tno_Seq
create sequence teacher_tno_Seq
  increment by 1
  start with 1
  minvalue 1
  maxvalue 999999999;

--DROP SEQUENCE application_id_Seq
--���ű�
insert into dept values(dept_dno_Seq.Nextval,'�������','����1','18804539085','���ѧԺ');
insert into dept values(dept_dno_Seq.Nextval,'��Ϣ��ȫ','����2','13982736473','���ѧԺ');
insert into dept values(dept_dno_Seq.Nextval,'�о���Ժ��','����3','17768237238','���ѧԺ');
insert into dept values(dept_dno_Seq.Nextval,'ѧ����','����4','15180457236','���ѧԺ');
-- delete from dept where dept.dno='1';
-- delete from dept where dept.dno='2';
-- delete from dept where dept.dno='3';
-- delete from dept where dept.dno='4';
-- update dept set dcollege ='���ѧԺ' where dept.dno='1';
-- update dept set dcollege ='���ѧԺ' where dept.dno='2';
-- update dept set dcollege ='���ѧԺ' where dept.dno='3';
-- update dept set dcollege ='���ѧԺ' where dept.dno='4';
-- select * from dept
--�༶��
--�������1701
--��Ϣ��ȫ171
insert into class values('1701','�������1701��','1','2017��','������','18146618512','�ർ1','�ർ1�绰');
insert into class values('1702','�������1702��','1','2017��','������','18146618512','�ർ2','�ർ2�绰');
insert into class values('1703','�������1703��','1','2017��','������','18146618512','�ർ3','�ർ3�绰');
insert into class values('1704','�������1704��','1','2017��','������','18146618512','�ർ4','�ർ4�绰');
insert into class values('1705','�������1705��','1','2017��','������','18146618512','�ർ5','�ർ5�绰');
insert into class values('1706','�������1706��','1','2017��','������','18146618512','�ർ6','�ർ6�绰');
insert into class values('1707','�������1707��','1','2017��','��ΰ','18146618512','�ർ7','�ർ7�绰');
insert into class values('1708','�������1708��','1','2017��','��ΰ','18146618512','�ർ8','�ർ8�绰');
insert into class values('1709','�������1709��','1','2017��','����','18146618512','�ർ9','�ർ9�绰');
insert into class values('1710','�������1710��','1','2017��','��ΰ','18146618512','�ർ10','�ർ10�绰');

insert into class values('171','��Ϣ��ȫ1701��','2','2017��','����Ա1','18146618512','�ർ1','�ർ1�绰');
insert into class values('172','��Ϣ��ȫ1702��','2','2017��','����Ա2','18146618512','�ർ1','�ർ1�绰');
insert into class values('173','��Ϣ��ȫ1703��','2','2017��','����Ա3','18146618512','�ർ1','�ർ1�绰');
insert into class values('174','��Ϣ��ȫ1704��','2','2017��','����Ա4','18146618512','�ർ1','�ർ1�绰');
-- delete from class where cno='1701';
-- delete from class where cno='1702';
-- delete from class where cno='1703';
-- delete from class where cno='1704';
-- delete from class where cno='1705';
-- delete from class where cno='1706';
-- delete from class where cno='1707';
-- delete from class where cno='1708';
-- delete from class where cno='1709';
-- delete from class where cno='1710';
-- delete from class where cno='171';
-- delete from class where cno='172';
-- delete from class where cno='173';
-- delete from class where cno='174';
-- select * from class


select * from STUDENT;
--ѧ����
insert into student values('8002117247','ţ����','Ů',to_date('1999-07-19','YYYY-MM-DD'),'10#503','1706','nky','13546569607','0','6217****404');
--�������������ǵ�¼��
insert into student values('111','������','Ů',to_date('1999-07-19','YYYY-MM-DD'),'10#503','1706','111','13546569607','0','6217****404');
-- delete from student where sno='8002117247';
-- delete from student where sno='111';


--��ʦ��
insert into teacher values(teacher_tno_Seq.nextval,'������','Ů',to_date('1987-01','YYYY-MM'),'4','��ʦ1�绰','��ʦ','0001','0','��ʦ1����');
insert into teacher values(teacher_tno_Seq.nextval,'�Ӻ�','Ů',to_date('1987-02','YYYY-MM'),'4','��ʦ2�绰','������','0002','0','��ʦ2����');
insert into teacher values(teacher_tno_Seq.nextval,'��ѩ��','Ů',to_date('1987-03','YYYY-MM'),'4','��ʦ3�绰','����','0003','0','��ʦ3����');
insert into teacher values(teacher_tno_Seq.nextval,'����â','Ů',to_date('1967-04','YYYY-MM'),'4','��ʦ4�绰','����','0004','1','��ʦ4����');
insert into teacher values(teacher_tno_Seq.nextval,'������','Ů',to_date('1987-05','YYYY-MM'),'4','��ʦ5�绰','����','0005','0','��ʦ5����');
insert into teacher values(teacher_tno_Seq.nextval,'����','��',to_date('1987-06','YYYY-MM'),'4','��ʦ6�绰','�߹�','0006','0','��ʦ6����');

--delete from teacher where teacher.tno='0001';
--delete from teacher where teacher.tno='0002';
-- delete from teacher where teacher.tno='0003';
-- delete from teacher where teacher.tno='0004';
-- delete from teacher where teacher.tno='0005';
-- delete from teacher where teacher.tno='0006';
-- delete from teacher where teacher.tno='0007';
-- delete from teacher where teacher.tno='0008';
-- delete from teacher where teacher.tno='0010';
-- select * from teacher


--����Ա��
insert into administrator values('admin1001','hwj','���Ŀ�');
insert into administrator values('admin1002','zsr','��˼��');
insert into administrator values('admin1003','nky','ţ����');

--�ɹ����ͱ�
insert into result_type values('0','����');
insert into result_type values('1','��Ʒ');

--�������ͱ�
insert into level_type values('0','���Ҽ�');
insert into level_type values('1','ʡ��');

--���������ͱ�
insert into prize_type values('1','�صȽ�');
insert into prize_type values('2','һ�Ƚ�');
insert into prize_type values('3','���Ƚ�');
insert into prize_type values('4','���Ƚ�');
insert into prize_type values('5','���㽱');

--select * from award_type;
--�����ͱ�
--�н���
--���ص㾺����Ŀ��
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

--��һ�㾺����Ŀ��
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

--�޽���
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','1','0','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'1','0','0','5',0,0);

insert into award_type values(award_type_atid_Seq.Nextval,'0','1','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','1','0','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','1','5',0,0);
insert into award_type values(award_type_atid_Seq.Nextval,'0','0','0','5',0,0);

--�������ͱ�
--��ע 1 ���ص㣨A�ࣩ 0 ��һ��
--��ע 1������ 0����Ʒ
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���������+����ѧ�����´�ҵ����','����������ز�ί','1A','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���������֡���������������','�������ߵ�ѧУ�Զ������ѧָ��ίԱ������֣��й����������޹�˾','1A','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ��������ƾ���','�ߵȽ���˾��ҵ����Ϣ��ҵ��','1A','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'������������','�������߽�˾ί��ȫ����������������ίԱ��','1A','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ACM���ʴ�ѧ����̾���','���������Э��','1A','1','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ASC�����ѧ���������������','���ʳ�������������ί�ᣨISC�����ʸ����ܼ�����ѯίԱ�ᣨHPC��','1A','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ս����ȫ����ѧ������ѧ���Ƽ���Ʒ����','�����������й���Э��������ȫ��ѧ���ٰ����������','1A','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ս�����й���ѧ����ҵ�ƻ�����','�����������й���Э��������ȫ��ѧ���ٰ����������','1A','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'������ѧ��ģ����','������ѧ����Ӧ�����ϻ�','1A','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'SOPC������ƾ���','ȫ����ѧ��������ƾ�������������ί������ALTERA��˾','1B','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ����ѧ��ģ����',' ','1B','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ�������˴��� RoboMaster','����������ȫ��ѧ����������������','1C','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ�����רҵ�˲�����뿪������','���Ų����������й����Э��','1C','0','');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���й���ѧ������������´�ҵ����','�л����񹲺͹��������л����񹲺͹�����','1C','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'�������ӱ����й�����������ս����ԭȫ����ѧ���������ӱ�����ҵ�Զ�����ս����','�������ߵ�ѧУ�Զ�����רҵ��ѧָ��ίԱ�������ӣ��й������޹�˾�й�����ѧ��','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'CCF��������������ܴ�����CCF-BDCI��','�й������ѧ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'CCF��ѧ�������ϵͳ�������ƾ�����CCF-CCSP��','�й������ѧ��','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'������-2019�����簲ȫ���������׽칤ҵ��������ȫ����','�й�������Э���й���Ϣͨ���о�Ժ���ҹ�ҵ��Ϣ��ȫ��չ�о�����','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ʡ��ѧ���������Ʒ��','�������Ǹ�ʡ�����ѧ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ʡ��ѧ���Ƽ�������ְҵ���ܾ���','ʡ������ʡ�ߵ�ԺУ�Ƽ������칫��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ʡ����ϵͳ���簲ȫ���ܴ���','�й�����ʡί������ί����ʡ����������ʡ���ʹ�ϵ�о�����','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'���ű�ȫ���������Ϣ����רҵ�˲Ŵ���','��ҵ����Ϣ�����˲Ž������Ľ�����ȫ���ߵ�ѧУѧ����Ϣ��ѯ��ҵָ���������Ͼٰ�','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ��������ƾ���Ƕ��ʽϵͳר��������','�ߵȽ���˾��ҵ����Ϣ��ҵ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���˹����ܴ��´���','�й���У�Ƽ��ɹ���������ί���й���У�����ϣ��Ƽ��ɹ�ת�����Ĺ㶫ʡ�����н����ֺͰ����ǿ�����о�ѧ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ����������ƾ�����TI����','�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ����Ϣ��ȫ����������������������','������ѧУ�滮���跢չ�����й���Ϣ��ȫ��������','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����У������Ӧ�ô��´�����BDIC��','�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����У�Ƽ���Ӧ�ô��´���','�������Ƽ���չ����','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���ѧ��VRAR��������','VRCORE���Ϻ���ͨ��ѧ���Ͼٰ�','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���ѧ��������ƾ��������CCPC������','�ߵ�ѧУ���Ҽ�ʵ���ѧʾ��������ϯ���й���ѧ��������ƾ���Э��','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���ѧ���������ƴ���','�й��ߵȽ���ѧ�ᡢ�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ���','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���У���������-��������ս��','�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ���������רҵ��ѧָ��ίԱ�������γ̽�ѧָ��ίԱ��ȫ���ߵ�ѧУ����������о���','0','1','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���У���������-����������������������','�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ���������רҵ��ѧָ��ίԱ�������γ̽�ѧָ��ίԱ��ȫ���ߵ�ѧУ����������о���','0','1','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���У���������-΢��С����Ӧ�ÿ�����','�������ߵ�ѧУ�������רҵ��ѧָ��ίԱ��������ߵ�ѧУ��ѧ�������רҵ��ѧָ��ίԱ��ȫ���ߵ�ѧУ����������о���','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й������˴���','�������ߵ�ѧУ�Զ�����ѧָ��ίԱ��','0','0','�ο��ļ�2');
insert into com_table values(com_table_ctid_Seq.Nextval,'�����ֱ���ȫ����ѧ�������������ƴ���','��ҵ����Ϣ���������뿼�����Ĵ���ʱ���Ƽ��������޹�˾','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'���й����������ѧ�������ƴ���','��ҵ����Ϣ�����������ͽ���ʡ��������','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'�����Ρ�ȫ����ѧ����Դ����������','�й�����ջ��������','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'����Ϊ�����й���ѧ��������ƾ���','�й��˹�����ѧ��������ߵ�ѧУ�������רҵ��ѧָ��ίԱ��','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'�����ֱ�����������Ƽ����´���','�й�����ʡί�˲Ű칲���Ž���ʡί����ʡ����������ʡ�Ƽ�������ʡ����ί����ʡ��ѧԺ','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ACM-ICPC���ʴ�ѧ��������ƾ���','���ʼ����Э��','0','1','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ʡ��ѧ��������ƴ���','','0','1','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'����ʡ��Ϣ��ȫ����','','0','1','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ��������������ƴ���','�������ߵȽ���˾�����������ߵ�ѧУ��������ѧָ��ίԱ��','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ������������Ӧ�ô���','�й�������Э��','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ�����뼼������','�й�����ѧ��','0','1','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ���ƶ��������´���','�й�ͨ��ѧ��ȫ���ƶ���������ҵ��������','0','0','�ο��ļ�3');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ��������������','�������ߵ�ѧУ�Զ���רҵ��ѧָ����ίԱ��','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���������񡰴��¡����⼰��ҵ����ս��','�������ߵ�ѧУ��������רҵ��ѧָ��ίԱ��','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ������ѵ���ۺ���������','�������ߵȽ���˾','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ�����´�ҵѵ���ƻ����չʾ','���Ҽ���ѧ�����´�ҵѵ���ƻ�ר�ҹ�����','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���Ƚ���ͼ�������Ʒ��Ϣ��ģ���´���','�������ߵ�ѧУ����ͼѧ��ѧָ��ίԱ���й�ͼѧѧ����ͼ����רҵίԱ���й�ͼѧѧ���Ʒ��Ϣ��ģרҵίԱ��','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ά���ֻ�������ƴ�������ѧ���飩','������ί���������ҵ��Ϣ����ѵ����','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'ȫ����ѧ���г��������������','�������ߵ�ѧУͳ��ѧ��רҵ��ѧָ��ίԱ���й���ҵͳ��ѧ��','0','0','�ο��ļ�1');
insert into com_table values(com_table_ctid_Seq.Nextval,'�й���ѧ���������Ʒ����','','0','0','�ο��ļ�1');


alter table dept rename column college to dcollege;