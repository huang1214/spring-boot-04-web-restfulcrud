--创建登陆存储过程
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
    --用户不存在
    returnvalue := 0;
  end if;
  if (get_user_s!=0 and get_user_t=0)  then
    --该用户可能为学生
    select spwd into get_spwd from student where sno=login_id;
    if (login_pwd != get_spwd) then
       --用户密码不正确
      returnvalue := 1;
    else
      --学生登陆成功
      returnvalue :=2;
    end if;
  end if;
  if (get_user_s=0 and get_user_t!=0)  then
    --该用户可能为老师
    select tpwd into get_tpwd from teacher where tno=login_id;
    if (login_pwd != get_tpwd) then
       --用户密码不正确
      returnvalue := 1;
    else
      --老师登陆成功
      returnvalue :=3;
    end if;
  end if;
end;
  
 
/
