package com.aca.springboot.service;

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
/*    add(comName,applicantId,teacher1Id,teacher2Id,unit,leader,teamNum,team,studentPrice,teacherPrice,
        awardTypeId,awardDate,applicantBankCard,workName,workBriefIntro)*/
    public int add(String comName,
                    String applicantId,
                    String teacher1Id,
                    String teacher2Id,
                    String unit,
                    String leader,
                    String teamNum,
                    String team,
                    String studentPrice,
                    String teacherPrice,
                    String awardTypeId,
                    String awardDate,
                    String applicantBankCard,
                    String workName,
                    String workBriefIntro) {
        Map map = new HashMap<String,String>();
        map.put("comName",comName);
        map.put("applicantId",applicantId);
        map.put("teacher1Id",teacher1Id);
        map.put("teacher2Id",teacher2Id);
        map.put("unit",unit);
        map.put("leader",leader);
        map.put("teamNum",teamNum);
        map.put("team",team);
        map.put("studentPrice",studentPrice);
        map.put("teacherPrice",teacherPrice);
        map.put("awardTypeId",awardTypeId);
        map.put("awardDate",awardDate);
        map.put("applicantBankCard",applicantBankCard);
        map.put("workName",workName);
        map.put("workBriefIntro",workBriefIntro);
        return applicationMapper.add(map);
    }

    public List com_name(){
        return applicationMapper.com_name();
    }

    /**
     * 通过输入的竞赛名称，作品类型，所获奖项类型，所获奖项等级，来获得奖金类型
     * @param comName
     * @param level_type
     * @param prize_type
     */
    public String getawardtype(String comName,
                             String level_type,
                             String prize_type){
        Map map = new HashMap<String,String>();
        map.put("u_comName",comName);
        map.put("u_level_type",level_type);
        map.put("u_prize_type",prize_type);
        applicationMapper.getawardtype(map);
        String rewardtype = (String)map.get("awardtype");
        return rewardtype;
    }

    public Map get_price(String atid){
        return applicationMapper.get_price(atid);
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
