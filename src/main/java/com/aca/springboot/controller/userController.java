package com.aca.springboot.controller;

import com.aca.springboot.service.UserService;
import com.aca.springboot.service.testService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class userController {
    @Autowired
    UserService userService;

    @Autowired
    private testService testService;

    /**
     * 修改密码
     * @param new_pwd1
     * @param new_pwd2
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/change_admin")
    public ModelAndView changepwd(@RequestParam("new_pwd1") String new_pwd1,
                            @RequestParam("new_pwd2") String new_pwd2,
                            HttpSession session){
        ModelAndView mv = new ModelAndView("redirect:/admin/changepwd_admin");
        String adminpwd = new_pwd1;
        String adminid = session.getAttribute("loginUser").toString();
        int result = userService.changeAdminPwd(adminid,adminpwd);
        if( result == 1 ){
            return mv;
        }else{

        }
        return mv;
    }

    /**
     * 获取所有管理员信息
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/All_admin")
    public List getAll_admin(){
        return userService.adminList();
    }

    /**
     * 删除指定管理员信息
     * @param admin_id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/delete_admin")
    public ModelAndView delete_admin(@RequestParam("deleteAdmin_id") String admin_id){
        ModelAndView mv = new ModelAndView("redirect:/admin/manage_admin");
        int result = userService.delete_admin(admin_id);
        if(result == 1){
            return mv;
        }
        return mv;
    }

    /**
     * 插入新的管理员信息
     * @param id
     * @param pwd
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/insert_admin")
    public ModelAndView insert_user(@RequestParam("adminId") String id,
                              @RequestParam("adminpwd") String pwd,
                              @RequestParam("adminname") String name){
        int result = userService.insert_admin(id,pwd,name);
        ModelAndView mv = new ModelAndView("redirect:/admin/manage_admin");
        if(result == 1){
            return mv;
        }
        return mv;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/All_user")
    public List getAll_user(){
        return userService.listUser();
    }

    /**
     * 删除指定用户信息
     * @param userid
     * @return
     */
    @ResponseBody
    @GetMapping(value = "delete_user")
    public ModelAndView delete_user(@RequestParam("deleteUser_id") String userid){
        ModelAndView mv = new ModelAndView("redirect:/admin/manage_user");
        int result = userService.delete_user(userid);
        if(result == 1){
            return mv;
        }
        return mv;
    }

    /**
     * 插入新的用户信息
     * @param id
     * @param pwd
     * @param name
     * @param type
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/insert_user")
    public ModelAndView insert_user(@RequestParam("userid") String id,
                              @RequestParam("userpwd") String pwd,
                              @RequestParam("username") String name,
                              @RequestParam("usertype") String type){
        ModelAndView mv = new ModelAndView("redirect:/admin/manage_user");
        int result = userService.insert_user(id,pwd,name,type);
        if(result == 1){
            return mv;
        }
        return mv;
    }

    //关于教师信息处理部分
    /*
     * 获取后台所有教师信息
     * @return   所有信息，json数据格式
     */
    @ResponseBody
    @GetMapping(value = "/getAllTeacher")
    public JSONObject teacher_All(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数
        return userService.teacher_All(page,limit);
    }

/*    //点击搜索后，执行此方法
    @ResponseBody
    @RequestMapping(value = "/test/search")
    public JSONObject bbb(HttpServletRequest request,
                          @RequestParam("dname") String dname,
                          @RequestParam("dadmin") String dadmin){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数

        return testService.list_tset_search(page,limit,dname,dadmin);

    }*/
    //在“申请信息页面 >> 指导老师1弹出层-按条件查询 >> 关键词搜索”点击搜索后，执行此方法
    @ResponseBody
    @RequestMapping(value = "/teacher1/keyword_search")
    public JSONObject keyword_search(HttpServletRequest request,
                                     @RequestParam("tno") String tno,
                                     @RequestParam("tname") String tname,
                                     @RequestParam("dcollege") String dcollege,
                                     @RequestParam("dname") String dname,
                                     @RequestParam("ttitle") String ttitle){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数
        return userService.list_teacher1Id_search(page,limit,tno,tname,dcollege,dname,ttitle);
    }

    //教师删除
    @ResponseBody
    @GetMapping(value = "/admin/teacher/delete")
    public int teacher_Delete(HttpServletRequest request){
        String tno = request.getParameter("tno");
        return userService.teacher_Delete(tno);
    }

    @ResponseBody
    @GetMapping(value = "/admin/teacher/edit")
    public String teacher_Edit(@RequestParam("tno") String tno,@RequestParam("tname") String tname,
                            @RequestParam("tsex") String tsex,@RequestParam("tbirthday") String tbirthday,
                            @RequestParam("dname") String dname, @RequestParam("dcollege") String dcollege,
                            @RequestParam("ttel") String ttel, @RequestParam("ttitle") String ttitle,
                            @RequestParam("tstate") String tstate, @RequestParam("card_num") String card_num){
        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String dno = testService.get_dno(dname,dcollege);
        int result= userService.teacher_edit(tno, tname, tsex,tbirthday, dno, ttel, ttitle, tstate, card_num);
        if( result == 1 ){
            return "修改成功！";
        }else{
            return "修改失败！";
        }

    }

    @ResponseBody
    @GetMapping(value = "/admin/dept/name")
    public List dept_Name(){
        return testService.dept_Name();
    }

    @ResponseBody
    @GetMapping(value = "/admin/dept/college")
    public List dept_College(){
        return testService.dept_College();
    }

    @ResponseBody
    @GetMapping(value = "/admin/teacher/ttitle")
    public List all_Ttitle(){
        return userService.all_Ttitle();
    }

    @ResponseBody
    @RequestMapping(value = "/admin/teacher/search")
    public JSONObject teacher_Search(HttpServletRequest request,
                               @RequestParam("tname") String tname, @RequestParam("tsex") String tsex,
                               @RequestParam("dname") String dname, @RequestParam("dcollege") String dcollege,
                               @RequestParam("ttitle") String ttitle){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数
        return userService.teacher_search(page,limit,tname,tsex,dname,dcollege,ttitle);
    }
}
