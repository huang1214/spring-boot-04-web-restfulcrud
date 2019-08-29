package com.aca.springboot.service;

import com.aca.springboot.mapper.SuccessMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SuccessService {
    @Autowired
    SuccessMapper successMapper;
    public int add_succ(String leader_id,
                         String teacher_id,
                         String stu_price,
                         String tea_price,
                         String date_year,
                         String competition_id,
                         String is_check){
        Map map = new HashMap<String,String>();
        map.put("leader_id",leader_id);
        map.put("teacher_id",teacher_id);
        map.put("stu_price",stu_price);
        map.put("tea_price",tea_price);
        map.put("date_year",date_year);
        map.put("competition_id",competition_id);
        map.put("is_check",is_check);
        return successMapper.add_succ(map);
    }

    public String get_ctid(String ctname){
        String ctid = successMapper.get_ctid(ctname).get("CTID").toString();
        return ctid;
    }

    public Map get_price(String atid){
        return successMapper.get_price(atid);
    }

    public int check_work(String is_check,String app_id){
        return successMapper.check_work(is_check,app_id);
    }
}
