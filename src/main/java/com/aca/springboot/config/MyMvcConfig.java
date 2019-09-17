package com.aca.springboot.config;

import com.aca.springboot.component.LoginHandlerInterceptor;
import com.aca.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                /* 项目的路径*/
                /* 1.登录页面*/
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                /* 2.用户主页面*/
                registry.addViewController("/user_index.html").setViewName("user_index");
                registry.addViewController("/admin_index.html").setViewName("admin_index");
                /* 3.试用页面*/
                registry.addViewController("/pie_user.html").setViewName("pie_user");  //饼状图
                registry.addViewController("/user_info.html").setViewName("user_info"); //用户基本信息

                /* 4.普通用户*/
                registry.addViewController("user/dashboard").setViewName("/user/dashboard"); //仪表盘
                /* 4.1预算备案*/
                registry.addViewController("user/bill_notice").setViewName("/user/bill_notice"); //备案须知
                registry.addViewController("user/bill_form").setViewName("/user/bill_form"); //备案申报
                registry.addViewController("user/bill_state").setViewName("/user/bill_state"); //备案状态
                registry.addViewController("user/bill_history").setViewName("/user/bill_history"); //预算备案：历史信息
                /* 4.2成果管理*/
                registry.addViewController("user/application_notice").setViewName("/user/application_notice"); //申请须知
                registry.addViewController("user/application_form").setViewName("/user/application_form"); //申请信息
                registry.addViewController("user/application_state").setViewName("/user/application_state"); //申请状态
                registry.addViewController("user/application_history").setViewName("/user/application_history"); //成果管理：历史信息

            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }

}
