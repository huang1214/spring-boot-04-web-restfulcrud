package com.aca.springboot.mapper;

import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompetitionMapper {
    public List com_All();

    public int insert_com(@Param("ctname") String ctname,
                          @Param("host_unit") String host_unit,
                          @Param("com_type") String com_type,
                          @Param("reference_paper") String reference_paper);
}
