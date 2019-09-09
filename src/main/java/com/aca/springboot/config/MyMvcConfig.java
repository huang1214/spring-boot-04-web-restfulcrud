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
                /* 这是之前项目的路径*/
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/admin").setViewName("admin");
                registry.addViewController("/pie_user").setViewName("pie_user");
                registry.addViewController("/application/add").setViewName("/application/add");
                registry.addViewController("/application/status").setViewName("/application/status");
                registry.addViewController("/application/list").setViewName("/application/list");
                registry.addViewController("/application/notice").setViewName("/application/notice");
                registry.addViewController("/application/changepwd_user").setViewName("/application/changepwd_user");
                registry.addViewController("/admin/audit").setViewName("/admin/audit");
                registry.addViewController("/admin/competition").setViewName("/admin/competition");
                registry.addViewController("/admin/prize").setViewName("/admin/prize");
                registry.addViewController("/admin/manage_user").setViewName("/admin/manage_user");
                registry.addViewController("/admin/manage_admin").setViewName("/admin/manage_admin");
                registry.addViewController("/admin/changepwd_admin").setViewName("/admin/changepwd_admin");
                /* 这是现在项目的路径*/
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/user_index.html").setViewName("user_index");
                registry.addViewController("/admin_index.html").setViewName("admin_index");
                registry.addViewController("/pie_user.html").setViewName("pie_user");  //饼状图
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
