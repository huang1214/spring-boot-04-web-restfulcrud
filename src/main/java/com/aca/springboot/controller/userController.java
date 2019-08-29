package com.aca.springboot.controller;

import com.aca.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class userController {
    @Autowired
    UserService userService;

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
}
