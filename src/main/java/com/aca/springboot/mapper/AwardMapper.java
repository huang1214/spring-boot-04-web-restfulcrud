package com.aca.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Mapper
public interface AwardMapper {
    public List getAllAward();

    public int change_price(@Param("teacher_price") String teacher_price,
                                     @Param("student_price") String student_price,
                                     @Param("atid") String atid);
}
