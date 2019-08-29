package com.aca.springboot.controller;

import com.aca.springboot.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;

    /**
     * 获取后台所有竞赛信息
     * @return   所有信息，json数据格式
     */
    @ResponseBody
    @GetMapping(value = "/getAllCom")
    public List com_All(){
        return competitionService.com_All();
    }

    /**
     * 添加新举行的 竞赛信息
     * @param ctname       竞赛名称
     * @param host_unit    主办单位
     * @param com_type     竞赛类型
     * @param reference_paper   参考文件
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/insert_com")
    public ModelAndView insert_com(@RequestParam("ctname") String ctname,
                                   @RequestParam("host_unit") String host_unit,
                                   @RequestParam("com_type") String com_type,
                                   @RequestParam("reference_paper") String reference_paper){
        ModelAndView mv = new ModelAndView("redirect:/admin/competition");
        int result = competitionService.insert_com(ctname,host_unit,com_type,reference_paper);
        if(result == 1) {
            return mv;
        }
        return mv;
    }
}
