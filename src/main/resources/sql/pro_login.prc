--������½�洢����
create or replace procedure pro_login(
  login_id in varchar2,
  login_pwd in varchar2,
  returnvalue out number
)
as
  get_user_s integer;
  get_user_t integer;
  get_spwd student.spwd%type;
  get_tpwd teacher.tpwd%type;
begin
  select count(*) into get_user_s from student where sno=login_id;
  select count(*) into get_user_t from teacher where tno=login_id;
  if (get_user_s=0 and get_user_t=0)  then
    --�û�������
    returnvalue := 0;
  end if;
  if (get_user_s!=0 and get_user_t=0)  then
    --���û�����Ϊѧ��
    select spwd into get_spwd from student where sno=login_id;
    if (login_pwd != get_spwd) then
       --�û����벻��ȷ
      returnvalue := 1;
    else
      --ѧ����½�ɹ�
      returnvalue :=2;
    end if;
  end if;
  if (get_user_s=0 and get_user_t!=0)  then
    --���û�����Ϊ��ʦ
    select tpwd into get_tpwd from teacher where tno=login_id;
    if (login_pwd != get_tpwd) then
       --�û����벻��ȷ
      returnvalue := 1;
    else
      --��ʦ��½�ɹ�
      returnvalue :=3;
    end if;
  end if;
end;
  
 
/
