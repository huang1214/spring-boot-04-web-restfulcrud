package com.aca.springboot.controller;

import com.aca.springboot.entities.test;
import com.aca.springboot.service.testService;
import com.alibaba.fastjson.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @Autowired
    private com.aca.springboot.service.UserService UserService;

    @Autowired
    private testService testService;

    //用户登录
    /**
     * 修改过，if语句中将其改成存储过程中的2，1，0
     * 2 - 用户不存在
     * 1 - 用户名密码错误
     * 0 - 登陆成功
     * @param username
     * @param password
     * @param map
     * @param session
     * @return
     */

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        int tname= UserService.login(username,password);
        if(tname == 2 |tname == 3 ){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/user_index.html";
        }else if(tname == 1){
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }else if(tname == 0){
            map.put("msg","用户不存在");
            return  "login";
        }
        return "login";
    }
    //管理员登录
/*    @PostMapping(value = "/user/a_login")*/
    @PostMapping(value = "/user/a_login")
    public String admin_login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Map<String,Object> map, HttpSession session){
        int tname = UserService.a_login(username,password);
        if(tname == 2){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/admin_index.html";
        }else if(tname == 1){
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }else if(tname == 0){
            map.put("msg","用户不存在");
            return  "login";
        }
        return "login";
    }

    /**
     * 修改密码
     * @param new_pwd1
     * @param new_pwd2
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/change_user")
    public ModelAndView changepwd(@RequestParam("new_pwd1") String new_pwd1,
                                  @RequestParam("new_pwd2") String new_pwd2,
                                  HttpSession session){
        ModelAndView mv = new ModelAndView("redirect:/application/changepwd_user");
        String userpwd = new_pwd1;
        String userid = session.getAttribute("loginUser").toString();
        if(userpwd.equals( new_pwd2)){
            int result = UserService.changepwd(userid,userpwd);
            System.out.println(result + userid);
            if( result == 0 ){
                System.out.println("修改密码失败" + "   "+result);
            }else{
                return mv;
            }
        }else{
            //跳出弹窗，提示两次密码不正确
        }
        return mv;
    }



    //表格查询部门页面，测试
    @ResponseBody
    @GetMapping(value = "/test")
    public JSONObject aaa(HttpServletRequest request
    ){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数

        return testService.list_tset(page,limit);
    }

    //点击删除后访问controller中的此方法
    @ResponseBody
    @RequestMapping(value = "/test/dele")
    public int ccc(HttpServletRequest request){
        String id = request.getParameter("param");
        return testService.delete_dept(id);
    }

    //点击编辑后访问controller中的此方法
    @ResponseBody
    @RequestMapping(value = "/test/edit")
    public boolean bbb(HttpServletRequest request,@RequestBody test t){
        //int id = Integer.parseInt(request.getParameter("param"));

        System.out.println(t.getDno());
        System.out.println(t.getDadmin());
        return true;
    }

    //点击搜索后，执行此方法
    @ResponseBody
    @RequestMapping(value = "/test/search")
    public JSONObject bbb(HttpServletRequest request,
                          @RequestParam("dname") String dname,
                          @RequestParam("dadmin") String dadmin){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数

        return testService.list_tset_search(page,limit,dname,dadmin);

    }
}
