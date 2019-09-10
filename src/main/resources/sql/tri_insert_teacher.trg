create or replace trigger tri_insert_teacher
  before insert on teacher  
  for each row
declare
  -- local variables here
  tea number;
begin
  select count(*) into tea from teacher where :new.tno = teacher.tno;
  if tea != 0 then
    RAISE_APPLICATION_ERROR(-20003,'������ʦ��ְ�����Ѵ��ڣ�');
  end if;
end tri_insert_teacher;
/
