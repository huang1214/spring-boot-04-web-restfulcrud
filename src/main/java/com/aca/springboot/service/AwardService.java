package com.aca.springboot.service;


import com.aca.springboot.mapper.AwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AwardService {
    @Autowired
    AwardMapper awardMapper;

    /**
     * 全部奖金类型
     */
    public List getAllAward(){
        return awardMapper.getAllAward();
    }

    public int change_price(String teacher_price, String student_price, String atid){
        return awardMapper.change_price(teacher_price,student_price,atid);
    }
}
