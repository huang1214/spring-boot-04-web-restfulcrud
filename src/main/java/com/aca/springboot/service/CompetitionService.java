package com.aca.springboot.service;

import com.aca.springboot.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;

    public List com_All(){
        return competitionMapper.com_All();
    }

    public int insert_com(String name,String unit,String type,String paper){
        return competitionMapper.insert_com(name,unit,type,paper);
    }
}
