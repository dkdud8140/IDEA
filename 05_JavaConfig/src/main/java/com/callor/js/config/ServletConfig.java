package com.callor.js.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * servlet-context.xml 파일을 대신할 Java Config 클래스
 * 
 * @Configuration : 이 파일은 context.xml을 대신할 파일이다
 * @EnableWebMvc : 이제 Spring MVC 프로젝트의 servlet이 시작된
 *  servlet-context.xml, dispatcher-servlet.xml 등을 대신할 파일
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.callor.js.controller","com.callor.js.service"})
public class ServletConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");

        WebMvcConfigurer.super.addResourceHandlers(registry);

    }

    /**
     * method에 @Bean Annotation을 부착하면
     * 이 method는 반드시 객체를 생성해서 return해야하하한다.
     *
     * Spring 컨테이너는 프로젝트가 시작되는 시점에 이 method를 자동으로(강제로)실행하고
     * 생성된 객체를 컨테이너에 보관하여
     * 다른 곳에서 필요할 경우 주입하도록 준비해둔다.
     */
    @Bean
    public ViewResolver getViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);      // Resolver가 여러개일때는 setOrder로 순서를 지정해준다
        return viewResolver;
    }
}
