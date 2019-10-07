package com.aca.springboot.controller;

import com.aca.springboot.entities.application;
import com.aca.springboot.service.ApplicationService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

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
    @PostMapping(value="/add")
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
                            @RequestParam("file") MultipartFile file,
                      Map<String,Object> map, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/user/application_form");
        application app = new application();
        System.out.println("aaaaaaa");
        String awardTypeId = getawardtype(comName,level_type, prize_type);  //获取获奖类型编号
       /* System.out.println("获奖编号"+awardTypeId);*/
        //获取学生获奖金额stu_price
        String studentPrice = applicationService.get_price(awardTypeId).get("STUDENT_PRICE").toString();
        //获取老师获奖金额tea_price
        String teacherPrice = applicationService.get_price(awardTypeId).get("TEACHER_PRICE").toString();
/*        System.out.println("学生获奖金额"+studentPrice);
        System.out.println("老师获奖金额"+teacherPrice);*/
        System.out.println("上传的图片"+file);
/*
        现在这三个数据还没有添加
        certificateImg blob ,
        getAwardImg blob,
        highLight blob,*/

        //pic.setImg(bytes);
        Calendar currTime = Calendar.getInstance();
        String time = String.valueOf(currTime.get(Calendar.YEAR))+String.valueOf((currTime.get(Calendar.MONTH)+1));
        String path ="d:"+ File.separator+"img"+File.separator+time;   //图片保存路径
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();      //文件格式
        if(suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png") || suffix.equals(".gif")) {
            String fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()) {             //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();      //不存在创建文件夹
            }
            long size = 0;
            //保存
            try {
                file.transferTo(targetFile);
                size = file.getSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //添加
            InputStream is = null;//得到文件流
            try {
                is = new FileInputStream(targetFile);
                byte[] bytes = FileCopyUtils.copyToByteArray(is);//得到byte
                System.out.println("bbbbbbbbbbbb,"+comName);
                app.setComName(comName);
                app.setApplicantId(applicantId);
                app.setTeacher1Id(teacher1Id);
                app.setTeacher2Id(teacher2Id);
                app.setUnit(unit);
                app.setLeader(leader);
                app.setTeamNum(teamNum);
                app.setTeam(team);
                app.setStudentPrice(studentPrice);
                app.setTeacherPrice(teacherPrice);
                app.setAwardTypeId(awardTypeId);
                app.setAwardDate(awardDate);
                app.setApplicantBankCard(applicantBankCard);
                app.setWorkName(workName);
                app.setWorkBriefIntro(workBriefIntro);
                app.setCertificateImg(bytes);
                /*int result = applicationService.add(comName, applicantId, teacher1Id, teacher2Id, unit, leader, teamNum, team, studentPrice, teacherPrice, awardTypeId, awardDate, applicantBankCard, workName, workBriefIntro, bytes);//添加到数据库中*/
                int result=applicationService.add(app);

                if (result == 1) {
                    System.out.println("成功！");

                } else {
                    System.out.println("失败！");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        int result_app =  applicationService.add(comName,applicantId,teacher1Id,teacher2Id,unit,leader,teamNum,team,studentPrice,teacherPrice,awardTypeId,awardDate,applicantBankCard,workName,workBriefIntro);
//        System.out.println(result_app);
//        if(result_app == 1){
//            return mv;
//        }
//        return mv;
        }
        return mv;
    }

    /**
     * 奖金公示
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/application/listAllApplication")
    public JSONObject application_All(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));   //获取第几页
        int limit = Integer.parseInt(request.getParameter("limit")); //获取每页的最大条数
        return applicationService.application_All(page,limit);
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
