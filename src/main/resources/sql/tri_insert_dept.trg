create or replace trigger tri_insert_dept
  before insert on dept  
  for each row
declare
  -- local variables here
  dep number;
begin
  select count(*) into dep from dept where :new.dno = dept.dno;
  if dep != 0 then
    RAISE_APPLICATION_ERROR(-20004,'插入部门的编号已存在！');
  end if;
end tri_insert_dept;
/
