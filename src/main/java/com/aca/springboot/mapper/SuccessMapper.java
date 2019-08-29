package com.aca.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface SuccessMapper {
    //向申请成功表中添加信息
    public int add_succ(Map map);

    //获取竞赛名称编号
    public Map get_ctid(@Param("ctname") String ctname);

    //获取学生和老师的奖金
    public Map get_price(@Param("atid") String atid);

    public int check_work(@Param("is_check")String is_check,
                          @Param("app_id") String app_id);
}
