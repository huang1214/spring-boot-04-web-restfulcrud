create or replace trigger tri_insert_application
  before insert on application 
  for each row
declare 
  --�͸�ԭ�������žɱ�����ʦ��ѧ��ͬһ������ߵĽ�����
  s_price application.studentPrice%type;
  t_price application.teacherPrice%type;
  --ͬһѧ������ʦ�μӶ��ͬһ����
  num1 number :=0;
  num2 number :=0;
  --ѧ������ʦ�ܽ��
  s_price_sum application.studentPrice%type;
  t_price_sum application.teacherPrice%type;
  
  --temp Ϊ�������޼�ȥ�ɱ����ܵĽ���
  temp1 number :=0;     --����Ϊ3000��
  temp2 number :=0;     --����Ϊ20000��
begin
  
/*���ģ�ʦ�����н�����ͬһ���ͬһ������ͬһ�죩�а��͸�ԭ�򣬲��ظ����㣨�й涨�ĳ��⣩��*/
  select count(*)into num1 from application
                  where :new.applicantId=application.applicantId
                  and :new.comName = application.comName
                  and :new.comNum = application.comNum
                  and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY'); 
  if num1 !=0 THEN
     --ѧ������ȡ�͸�ԭ��
     select max(application.studentPrice) into s_price from application 
                      where :new.applicantId=application.applicantId
                      and :new.comName = application.comName
                      and :new.comNum = application.comNum
                      and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     --����²���Ľ�����������е�ѧ�������     
     if:new.studentPrice > s_price THEN
     --�ɱ�ѧ������ֶ���0      
     update application set application.studentPrice = 0
                      where :new.applicantId=application.applicantId
                      and :new.comName = application.comName
                      and :new.comNum = application.comNum
                      and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     else --�²���Ľ��ܾɱ�
     --�±���0
     :new.studentPrice :=0;
     end if; 
  end if;
  
  select count(*)into num2 from application 
                  where :new.teacher1Id=application.teacher1Id 
                  and :new.comName = application.comName
                  and :new.comNum = application.comNum
                  and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');                  
  if num2 !=0 THEN 
     --ָ����ʦ1 ����ȡ�͸�ԭ��
     select max(application.teacherPrice) into t_price from application 
                       where :new.teacher1Id=application.teacher1Id 
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');  
          
     if :new.teacherPrice > t_price THEN
     --�ɱ���ʦ����ֶ���0      
     update application set application.teacherPrice = 0
                       where :new.teacher1Id=application.teacher1Id 
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
     else --�±�Ľ��ܾɱ�
     --�±���0
     :new.teacherPrice := 0; 
     end if; 
  end if; 
  
  
/*  ���壩ÿλ�����˵��ξ�����ý��𲻳���3000Ԫ��ѧ���ۻ����𲻳���20000Ԫ��*/

  --�������жϳ���3000��
  select sum(application.studentPrice) into s_price_sum from application
                       where :new.applicantId=application.applicantId
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum;
  s_price_sum := nvl(s_price_sum,0)+:new.studentPrice;
  --dbms_output.put_line(s_price_sum); 
  IF s_price_sum >= 3000 THEN
    temp1 := 3000 - (s_price_sum - :new.studentPrice);
  END IF;
  --�������жϳ���20000 ��
  select sum(application.studentPrice)+:new.studentPrice into s_price_sum from application
                       where :new.applicantId=application.applicantId
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
  IF s_price_sum >= 20000 THEN
    temp2 := 20000 - (s_price_sum - :new.studentPrice);
    --dbms_output.put_line(temp2);
  END IF; 
  --temp1��temp2ȡֵ��������������������������Ҫ�޸ı��ٲ��룩
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
/*������ÿλָ����ʦ����Ŀ��һָ����ʦ�����ξ�����ͬһ��Ŀָ�����ѧ���������Ʒֻȡ��óɼ����㣩
      ��ý��𲻳���3000Ԫ��ѧ���ۻ����𲻳���20000Ԫ��*/
  
  --ָ����ʦ�жϳ���3000 ��
  select sum(application.teacherPrice)+:new.teacherPrice into t_price_sum from application
                       where :new.teacher1Id=application.teacher1Id
                       and :new.comName = application.comName
                       and :new.comNum = application.comNum;
  IF t_price_sum >= 3000 THEN
    temp1 := 3000 - (t_price_sum - :new.teacherPrice);
  END IF;
  --ָ����ʦ�жϳ���20000 ��
  select sum(application.teacherPrice)+:new.teacherPrice into t_price_sum from application
                       where :new.teacher1Id=application.teacher1Id
                       and to_char(application.awardDate,'YYYY')=to_char(:new.awardDate,'YYYY');
  IF t_price_sum >= 20000 THEN
    temp2 := 20000 - (t_price_sum - :new.teacherPrice);
    dbms_output.put_line(temp2); 
  END IF; 
  --temp1��temp2ȡֵ��������������������������Ҫ�޸ı��ٲ��룩
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
