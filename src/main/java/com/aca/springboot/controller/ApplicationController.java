package com.aca.springboot.controller;

import com.aca.springboot.entities.application;
import com.aca.springboot.service.ApplicationService;
import com.aca.springboot.service.SuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

/*    @Autowired
    SuccessService successService;*/

    /**
     * 插入数据，插入到两张表中
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value="/add")
    public ModelAndView add(@RequestParam("comName") String comName,
                      @RequestParam("workName") String workName,
                      @RequestParam("awardDate") String awardDate,
                      @RequestParam("unit") String unit,
                      @RequestParam("level_type") String level_type,
                      @RequestParam("prize_type") String prize_type,
                      @RequestParam("applicantId") String applicantId,
                      @RequestParam("applicantBankCard") String applicantBankCard,
                      @RequestParam("teacher1Id") String teacher1Id,
                      @RequestParam("teacher2Id") String teacher2Id,
                      @RequestParam("leader") String leader,
                      @RequestParam("teamNum") String teamNum,
                      @RequestParam("team") String team,
                      @RequestParam("workBriefIntro") String workBriefIntro,
                      Map<String,Object> map, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/user/application_form");
        String awardTypeId = getawardtype(comName,level_type, prize_type);  //获取获奖类型编号
        System.out.println("获奖编号"+awardTypeId);
        //获取学生获奖金额stu_price
        String studentPrice = applicationService.get_price(awardTypeId).get("STUDENT_PRICE").toString();
        //获取老师获奖金额tea_price
        String teacherPrice = applicationService.get_price(awardTypeId).get("TEACHER_PRICE").toString();
        System.out.println("学生获奖金额"+studentPrice);
        System.out.println("老师获奖金额"+teacherPrice);
/*
        现在这三个数据还没有添加
        certificateImg blob ,
        getAwardImg blob,
        highLight blob,*/
        int result_app =  applicationService.add(comName,applicantId,teacher1Id,teacher2Id,unit,leader,teamNum,team,studentPrice,teacherPrice,awardTypeId,awardDate,applicantBankCard,workName,workBriefIntro);
        System.out.println(result_app);
        if(result_app == 1){
            return mv;
        }
        return mv;
    }

    /**
     * 奖金公示
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/success/list")
    public List list(){
        return applicationService.work_paaAll();
    }

    /**
     * 获取全部的比赛名称
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/con_name")
    public List com_name(){
        return applicationService.com_name();
    }

    /**
     * 调用函数获取获奖类型
     * @return
     */
    @ResponseBody
    public String getawardtype(String u_comName, String u_level_type, String u_prize_type){
        return applicationService.getawardtype(u_comName,u_level_type, u_prize_type);
    }

    /**
     * 申请状态
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/check")
    public List workresult(HttpSession session){
        String id = session.getAttribute("loginUser").toString();
        return applicationService.workresult(id);
    }

    /**
     * 管理员审核获奖信息，判断是否有资格获取奖金
     * @param check_id
     * @return
     *//*
    @ResponseBody
    @GetMapping(value = "/check_work")
    public ModelAndView check(@RequestParam("check_id") String check_id){
        ModelAndView mv = new ModelAndView("redirect:/admin/audit");
        String[] sArray=check_id.split(",",2);
        int result = successService.check_work(sArray[0],sArray[1]);
        if(result == 1){
            return mv;
        }
        return mv;
    }*/
}
