package com.aca.springboot.service;

import com.aca.springboot.entities.json;
import com.aca.springboot.entities.test;
import com.aca.springboot.mapper.CompetitionMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;

    //表格初始化
    //“申请信息页面 >> 比赛名称弹出层 >> 表格初始化”
    public JSONObject com_All(int page, int limit){
        List<test> lists = competitionMapper.com_All();   //select后结果放入lists集合中
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

    //“申请信息页面 >> 比赛名称弹出层-按条件查询 >> 关键词搜索”
    public JSONObject list_ctname_search(int page,int limit,String search_ctname){
        List<test> lists = competitionMapper.ctname_search(search_ctname);
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
        System.out.println("这里执行国");
        System.out.println(jsonObj);
        return jsonObj;
    }

    public JSONObject com_search(int page, int limit, String ctname,
                                  String host_unit, String com_type,
                                  String result_type){
        List<test> lists = competitionMapper.com_search(ctname, host_unit, com_type, result_type);   //select后结果放入lists集合中
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
    public int insert_com(String name,String unit,String type,String paper){
        return competitionMapper.insert_com(name,unit,type,paper);
    }
}
