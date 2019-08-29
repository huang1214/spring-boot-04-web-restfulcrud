package com.aca.springboot.controller;

import com.aca.springboot.dao.applicationdao;
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

    @Autowired
    SuccessService successService;

    /**
     * 插入数据，插入到两张表中
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value="/add")
    public ModelAndView add(@RequestParam("competition_name") String competition_name,
                      @RequestParam("work_name") String work_name,
                      @RequestParam("leader_id") String leader_id,
                      @RequestParam("unit") String unit,
                      @RequestParam("teacher_id") String teacher_id,
                      @RequestParam("card_num") String card_num,
                      @RequestParam("date_year") String date_year,
                      @RequestParam("result_type") String result_type,
                      @RequestParam("prize_type") String prize_type,
                      @RequestParam("result_type") String level_type,
                      Map<String,Object> map, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/application/add");
        String award_id = getawardtype(competition_name, result_type, level_type, prize_type);  //获取获奖类型编号
        System.out.println(award_id);
        int result_app =  applicationService.add(competition_name,work_name,leader_id,unit,teacher_id,card_num,date_year,award_id);
        System.out.println(result_app);
        if(result_app == 1){
            //获取竞赛名称编号competition_id
            //select ctid from where ctname=competition_name;
            String competition_id =successService.get_ctid(competition_name);
            if(award_id.length()==1){
                award_id = award_id +" ";
            }
            //获取学生获奖金额stu_price
            String stu_price = successService.get_price(award_id).get("STUDENT_PRICE").toString();
            //获取老师获奖金额tea_price
            String tea_price = successService.get_price(award_id).get("TEACHER_PRICE").toString();
            int result_succ = successService.add_succ(leader_id,teacher_id,stu_price,tea_price,date_year,competition_id,"0");
            if(result_succ == 1){
/*                return "提交成功！";*/
                    return mv;
            }/*else{
*//*                return "提交失败！";*//*

            }*/
        }else{
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
    public String getawardtype(String competition_name, String result_type, String level_type, String prize_type){
        return applicationService.getawardtype(competition_name,result_type,level_type,prize_type);
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
     */
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
    }
}
