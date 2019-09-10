create or replace trigger tri_insert_class
  before insert on class  
  for each row
declare
  -- local variables here
  class_num number;
begin
  select count(*) into class_num from class where :new.cno = class.cno;
  if class_num != 0 then
    RAISE_APPLICATION_ERROR(-20005,'插入班级的编号已存在！');
  end if;
end tri_insert_class;
/
