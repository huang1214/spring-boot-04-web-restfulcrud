create or replace trigger tri_insert_student
  before insert on student  
  for each row
declare
  -- local variables here
  stu number;
begin
  select count(*) into stu from student where :new.sno = student.sno;
  if stu != 0 then
    RAISE_APPLICATION_ERROR(-20002,'插入学生的学号已存在！');
  end if;
end tri_insert_student;
/
