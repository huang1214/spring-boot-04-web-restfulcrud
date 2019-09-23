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

    //表格初始化
    public JSONObject list_tset(int page,int limit){
        List<test> lists = testMapper.test_json();   //select后结果放入lists集合中
        List<test> list = new ArrayList<>();
        int theLastPage = page * limit ;          //这里用于判断最后一页的最后一条理论上是第几条，然后跟实际的进行比较
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
        String jsonString = JSON.toJSONString(list);     //将集合转变为json格式的字符串
        JSONArray objects = JSON.parseArray(jsonString);  //将字符串转变为json数组，这里是将集合转变json数组

        json js = new json();     //创建一个json对象
        js.setCount(lists.size());
        js.setCode(0);
        js.setMsg("");
        js.setData(objects);
        String jsonTheLast = JSON.toJSONString(js);       //先将json类对象（此时就是普通的类对象）转变为json格式的字符串
        JSONObject jsonObj = JSON.parseObject(jsonTheLast);   //将字符串串转变为json对象（json数据格式），将对象转变为json数据格式。
        return jsonObj;   //返回json对象（json数据）
    }

    //表格条件查询，内容跟上面一模一样，就是加了两个where条件
    public JSONObject list_tset_search(int page,int limit,String dname,String dadmin){
        List<test> lists = testMapper.test_search(dname,dadmin);
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
