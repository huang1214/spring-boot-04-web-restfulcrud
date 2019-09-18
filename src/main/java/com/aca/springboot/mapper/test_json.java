package com.aca.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface test_json {
    public List test_json();

    public int delete_dept(@Param("dept_id") String dept_id);
}
