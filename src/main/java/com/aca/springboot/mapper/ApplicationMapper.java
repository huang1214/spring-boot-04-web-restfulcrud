package com.aca.springboot.mapper;

import com.aca.springboot.dao.applicationdao;
import com.aca.springboot.entities.application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface ApplicationMapper {

    public int add(Map map);

    //获取学生和老师的奖金
    public Map get_price(@Param("atid") String atid);

    public application get(int app_id);

    public List work_paaAll();

    public List com_name(); // 查询全部比赛名称

    public void getawardtype(Map map); //查询获奖类型

    public List workresult(Map map);
}
