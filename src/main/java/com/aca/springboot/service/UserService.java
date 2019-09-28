package com.aca.springboot.service;

import com.aca.springboot.entities.User;
import com.aca.springboot.entities.json;
import com.aca.springboot.entities.test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private com.aca.springboot.mapper.UserMapper UserMapper;

    //login（String，String）修改过
    //普通用户登录
    public int login(String username,String password){
        //map的格式是一个id对应一个值（id（不一定是整数型），value），我解释不太清楚，百度吧（笑哭.jpg）。
        Map<String,String > map = new HashMap<String,String>();    //资料上说存储过程传参只能通过map传参，所以再服务层定义一个map
        map.put("username",username);      //将username存入map中，括号前面带引号的可理解为map的id，后面就是对应id的值，这里是函数的传入参数
        map.put("password",password);
        UserMapper.login(map);        //调用存储过程，存储过程输出发结果存入map中，id为logintype，详见User.xml文件
        return Integer.parseInt(String.valueOf(map.get("logintype")));
    }

    //管理员登录
    public int a_login(String username,String password){
        //map的格式是一个id对应一个值（id（不一定是整数型），value），我解释不太清楚，百度吧（笑哭.jpg）。
        Map map = new HashMap<String,String>();    //资料上说存储过程传参只能通过map传参，所以再服务层定义一个map
        map.put("username",username);      //将username存入map中，括号前面带引号的可理解为map的id，后面就是对应id的值，这里是函数的传入参数
        map.put("password",password);
        UserMapper.a_login(map);        //调用存储过程，存储过程输出发结果存入map中，id为logintype，详见User.xml文件
        int logintype = Integer.parseInt(String.valueOf(map.get("logintype")));   //这里传出的logintype的类型为object型（我也不知道为啥），我将它转换成int型
        return logintype;
    }
    //普通用户
    public List listUser(){
        return UserMapper.listUser();
    }

    public int changepwd(String userid, String userpwd){
        return UserMapper.changepwd(userid,userpwd);
    }

    public int delete_user(String userid){ return UserMapper.delete_user(userid); }

    public int insert_user(String id,String pwd,String name,String type){ return UserMapper.insert_user(id,pwd,name,type); }

    //管理员
    public List adminList(){ return UserMapper.adminList(); }

    public int changeAdminPwd(String id,String pwd){ return UserMapper.changeAdminPwd(id,pwd); }

    public int delete_admin(String id){ return UserMapper.delete_admin(id); }

    public int insert_admin(String id,String pwd,String name){ return UserMapper.insert_admin(id,pwd,name); }

    //教师
    //表格初始化
    //“申请信息页面 >> 比赛名称弹出层 >> 表格初始化”
    public JSONObject teacher_All(int page, int limit){
        List<test> lists = UserMapper.teacher_All();   //select后结果放入lists集合中
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

        System.out.println(jsonObj);
        return jsonObj;   //返回json对象（json数据）
    }
}
