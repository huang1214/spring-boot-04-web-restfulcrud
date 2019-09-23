package com.aca.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface test_json {
    //查询所有结果
    public List test_json();

    //条件查询结果
    public List test_search(@Param("dname") String dname, @Param("dadmin") String dadmin);

    public int delete_dept(@Param("dept_id") String dept_id);
}
