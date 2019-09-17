package com.aca.springboot.service;

import com.aca.springboot.entities.json;
import com.aca.springboot.entities.test;
import com.aca.springboot.mapper.test_json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class testService {
    @Autowired
    private test_json testMapper;

    public JSONObject list_tset(int page,int limit){
        List<test> lists = testMapper.test_json();
        List<test> list = new ArrayList<>();
        int theLastPage = page * limit ;
        if( theLastPage > lists.size())   //如果是最后一页，就是说最后一页的最后一条大于此集合的大小，只显示到集合的最后一条
        {
            for( int i = (page-1)*limit; i <lists.size();i++){
                list.add(lists.get(i));
            }
        }else{
            for( int i = (page-1)*limit; i < theLastPage;i++){    //平时显示页面
                list.add(lists.get(i));
            }
        }
        String jsonString = JSON.toJSONString(list);
        JSONArray objects = JSON.parseArray(jsonString);

        json js = new json();
        js.setCount(lists.size());
        js.setCode(0);
        js.setMsg("");
        js.setData(objects);
        String jsonTheLast = JSON.toJSONString(js);
        JSONObject jsonObj = JSON.parseObject(jsonTheLast);
        return jsonObj;
    }

    public int delete_dept(String dept_id){ return testMapper.delete_dept(dept_id); }
}
