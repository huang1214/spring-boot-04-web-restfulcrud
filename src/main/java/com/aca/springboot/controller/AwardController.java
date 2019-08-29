package com.aca.springboot.controller;

import com.aca.springboot.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AwardController {
    @Autowired
    AwardService awardService;

    /**
     * 获取全部奖金类型
     */
    @ResponseBody
    @GetMapping(value = "/getAllAward")
    public List getAllAward(){
        return awardService.getAllAward();
    }

    @ResponseBody
    @GetMapping(value = "/change_price")
    public ModelAndView change(@RequestParam("changeprice_id") String changeprice_id,
                               @RequestParam("teacher_price") String teacher_price,
                               @RequestParam("student_price") String student_price,
                               Map<String,Object> map){
        ModelAndView mv = new ModelAndView("redirect:/admin/prize");
        int result = awardService.change_price(teacher_price,student_price,changeprice_id);
        if(result == 1){
            map.put("msg","修改成功！");
            System.out.println(result);
            return mv;
        }else {
            map.put("msg","修改失败！");
            System.out.println(result );
/*            return "修改失败";*/
        }
        return mv;
    }
}
