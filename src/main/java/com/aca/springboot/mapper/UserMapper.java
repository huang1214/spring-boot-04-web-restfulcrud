package com.aca.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public List listUser();

    //login(map)修改过
    //普通用户登录
    public void login(Map map);

    //管理员登录
    public void a_login(Map map);

    public int changepwd(@Param("userid") String userid, @Param("userpwd") String userpwd);

    public int delete_user(@Param("userid") String userid);

    public int insert_user(@Param("userid") String userid,
                           @Param("userpwd") String userpwd,
                           @Param("username") String username,
                           @Param("usertype") String usertype);

    public List adminList();

    public int changeAdminPwd(@Param("adm_id") String adm_id,@Param("adm_pwd") String adm_pwd);

    public int delete_admin(@Param("adm_id") String adm_id);

    public int insert_admin(@Param("adm_id") String adm_id,@Param("adm_pwd") String adm_pwd,@Param("adm_name") String adm_name);

}
