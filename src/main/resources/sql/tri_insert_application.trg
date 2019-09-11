create or replace trigger tri_insert_application
  before insert on application 
  for each row
declare 
  --就高原则里面存放旧表中老师或学生同一比赛最高的奖金额度
  s_price application.studentPrice%type;
  t_price application.teacherPrice%type;
  --同一学生或老师参加多次同一竞赛
  num1 number :=0;
  num2 number :=0;
  --学生或老师总金额
  s_price_sum application.studentPrice%type;
  t_price_sum application.teacherPrice%type;
  
  --temp 为奖金上限减去旧表中总的奖金
  temp1 number :=0;     --上限为3000的
  temp2 number :=0;     --上限为20000的
begin
  
/*（四）师生所有奖励在同一年度同一竞赛（同一届）中按就高原则，不重复计算（有规定的除外）。*/
  select count(*)into num1 from application
                  where :new.applicantId=application.applicantId
                  and :new.comName = application.comName
                  and :new.comNum = application.comNum
                  and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY'); 
  if num1 !=0 THEN
     --学生金额采取就高原则
     select max(application.studentPrice) into s_price from application 
                      where :new.applicantId=application.applicantId
                      and :new.comName = application.comName
                      and :new.comNum = application.comNum
                      and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     --如果新插入的金额大于申请表中的学生最大金额     
     if:new.studentPrice > s_price THEN
     --旧表学生金额字段置0      
     update application set application.studentPrice = 0
                      where :new.applicantId=application.applicantId
                      and :new.comName = application.comName
                      and :new.comNum = application.comNum
                      and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     else --新插入的金额≤旧表
     --新表置0
     :new.studentPrice :=0;
     end if; 
  end if;
  
  select count(*)into num2 from application 
                  where :new.teacher1Id=application.teacher1Id 
                  and :new.comName = application.comName
                  and :new.comNum = application.comNum
                  and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');                  
  if num2 !=0 THEN 
     --指导老师1 金额采取就高原则
     select max(application.teacherPrice) into t_price from application 
                       where :new.teacher1Id=application.teacher1Id 
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');  
          
     if :new.teacherPrice > t_price THEN
     --旧表老师金额字段置0      
     update application set application.teacherPrice = 0
                       where :new.teacher1Id=application.teacher1Id 
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     else --新表的金额≤旧表
     --新表置0
     :new.teacherPrice := 0; 
     end if; 
  end if; 
  
  
/*  （五）每位负责人单次竞赛获得奖金不超过3000元，学年累积奖金不超过20000元。*/

  --负责人判断超过3000的
  select sum(application.studentPrice) into s_price_sum from application
                       where :new.applicantId=application.applicantId
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum;
  s_price_sum := nvl(s_price_sum,0)+:new.studentPrice;
  --dbms_output.put_line(s_price_sum); 
  IF s_price_sum >= 3000 THEN
    temp1 := 3000 - (s_price_sum - :new.studentPrice);
  END IF;
  --负责人判断超过20000 的
  select sum(application.studentPrice)+:new.studentPrice into s_price_sum from application
                       where :new.applicantId=application.applicantId
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
  IF s_price_sum >= 20000 THEN
    temp2 := 20000 - (s_price_sum - :new.studentPrice);
    --dbms_output.put_line(temp2);
  END IF; 
  --temp1和temp2取值的四种情况（其中有两种情况需要修改表再插入）
  IF  (temp1=0 and temp2<>0) THEN 
    :new.studentPrice := temp2;
  END IF;
  IF (temp1<>0 and temp2=0) THEN 
    :new.studentPrice := temp1; 
  END IF;    
  IF (temp1<>0 and temp2<>0) THEN
    if  temp1<temp2 then
      :new.studentPrice := temp1;
    else
      :new.studentPrice := temp2;      
    end if;   
  END IF;  
  temp1 :=0;
  temp2 :=0;
/*（六）每位指导老师（项目第一指导老师）单次竞赛（同一项目指导多个学生、多个作品只取最好成绩计算）
      获得奖金不超过3000元，学年累积奖金不超过20000元。*/
  
  --指导老师判断超过3000 的
  select sum(application.teacherPrice)+:new.teacherPrice into t_price_sum from application
                       where :new.teacher1Id=application.teacher1Id
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum;
  IF t_price_sum >= 3000 THEN
    temp1 := 3000 - (t_price_sum - :new.teacherPrice);
  END IF;
  --指导老师判断超过20000 的
  select sum(application.teacherPrice)+:new.teacherPrice into t_price_sum from application
                       where :new.teacher1Id=application.teacher1Id
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
  IF t_price_sum >= 20000 THEN
    temp2 := 20000 - (t_price_sum - :new.teacherPrice);
    dbms_output.put_line(temp2); 
  END IF; 
  --temp1和temp2取值的四种情况（其中有两种情况需要修改表再插入）
  IF  (temp1=0 and temp2<>0) THEN 
    :new.teacherPrice := temp2;
  END IF;
  IF (temp1<>0 and temp2=0) THEN 
    :new.teacherPrice := temp1; 
  END IF;    
  IF (temp1<>0 and temp2<>0) THEN
    if  temp1<temp2 then
      :new.teacherPrice := temp1;
    else
      :new.teacherPrice := temp2;      
    end if;   
  END IF;  
  
  IF(:new.teacher1Id is null ) THEN
    :new.teacherPrice := 0;
  END IF;
end tri_insert_application;
/
