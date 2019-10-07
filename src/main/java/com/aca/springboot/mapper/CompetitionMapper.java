package com.aca.springboot.mapper;

import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompetitionMapper {
    public List com_All();

    //条件查询结果  按照比赛名称关键词查找比赛名称
    public List ctname_search(@Param("search_ctname") String search_ctname);

    public int insert_com(@Param("ctname") String ctname,
                          @Param("host_unit") String host_unit,
                          @Param("com_type") String com_type,
                          @Param("reference_paper") String reference_paper);

    public List com_search(@Param("ctname") String ctname,
                           @Param("host_unit") String host_unit,
                           @Param("com_type") String com_type,
                           @Param("result_type") String result_type);
}
