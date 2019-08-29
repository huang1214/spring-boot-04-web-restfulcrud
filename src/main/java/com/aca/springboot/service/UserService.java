package com.aca.springboot.service;

import com.aca.springboot.entities.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Map map = new HashMap<String,String>();    //资料上说存储过程传参只能通过map传参，所以再服务层定义一个map
        map.put("username",username);      //将username存入map中，括号前面带引号的可理解为map的id，后面就是对应id的值，这里是函数的传入参数
        map.put("password",password);
        UserMapper.login(map);        //调用存储过程，存储过程输出发结果存入map中，id为logintype，详见User.xml文件
        int logintype = Integer.parseInt(String.valueOf(map.get("logintype")));   //这里传出的logintype的类型为object型（我也不知道为啥），我将它转换成int型
        return logintype;
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
}
