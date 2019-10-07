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
    //弹出层列出所有指导老师信息
    public List teacher_All();
    //tno,tname,dcollege,dname,ttitle
    //条件查询结果  按照指导老师关键词查找比赛名称
    public List teacher1Id_search(@Param("tno") String tno,
                                  @Param("tname") String tname,
                                  @Param("dcollege") String dcollege,
                                  @Param("dname") String dname,
                                  @Param("ttitle") String ttitle);


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

    //教师的删除
    public int teacher_Delete(@Param("tno") String tno);
    //对教师的编辑
    public int teacher_edit(@Param("tno") String tno,@Param("tname") String tname,@Param("tsex") String tsex,
                            @Param("tbirthday") String tbirthday,@Param("dno") String dno,@Param("ttel") String ttel,
                            @Param("ttitle") String ttitle,@Param("tstate") String tstate,@Param("card_num") String card_num);

    public List all_Ttitle();
    //对教师编辑
    public List teacher_search(@Param("tname") String tname,@Param("tsex") String tsex,@Param("dname") String dname,
                               @Param("dcollege") String dcollege,@Param("ttitle") String ttitle);

}
