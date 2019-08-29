package com.aca.springboot.service;

import com.aca.springboot.dao.applicationdao;
import com.aca.springboot.entities.application;
import com.aca.springboot.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    /**
     * 插入数据
     */
    public int add(String competition_name,
                    String work_name,
                    String leader_id,
                    String unit,
                    String teacher_id,
                    String card_num,
                    String date_year,
                    String award_id) {
        Map map = new HashMap<String,String>();
        map.put("competition_name",competition_name);
        map.put("work_name",work_name);
        map.put("leader_id",leader_id);
        map.put("unit",unit);
        map.put("teacher_id",teacher_id);
        map.put("card_num",card_num);
        map.put("date_year",date_year);
        map.put("award_id",award_id);
        return applicationMapper.add(map);
    }

/*    public void delete(int id) {
        applicationMapper.delete(id);
    }*/

/*    public application get(int id) {
        return applicationMapper.get(id);
    }*/

    public List com_name(){
        return applicationMapper.com_name();
    }

    /**
     * 通过输入的竞赛名称，作品类型，所获奖项类型，所获奖项等级，来获得奖金类型
     * @param competition_name
     * @param result_type
     * @param level_type
     * @param prize_type
     */
    public String getawardtype(String competition_name,
                             String result_type,
                             String level_type,
                             String prize_type){
        Map map = new HashMap<String,String>();
        map.put("u_competition_name",competition_name);
        map.put("u_result_type",result_type);
        map.put("u_level_type",level_type);
        map.put("u_prize_type",prize_type);
        applicationMapper.getawardtype(map);
        String rewardtype = (String)map.get("awardtype");
        return rewardtype;
    }

    /**
     * 获取用户id，查看自己全部获奖作品的审核情况
     * @param leader_id
     * @return
     */
    public List workresult(String leader_id){
        Map map = new HashMap<String,String>();
        map.put("leader_id",leader_id);
        return applicationMapper.workresult(map);
    }

    public List work_paaAll(){
        return applicationMapper.work_paaAll();
    }

}
