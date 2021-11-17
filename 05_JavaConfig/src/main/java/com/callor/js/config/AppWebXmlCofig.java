package com.callor.js.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * AbstractAnnotationConfigDispatcherServletInitializer : 추상클래스
 * web.xml을 대신할 config 클래스
 */
public class AppWebXmlCofig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // <context-param>에 설정한 root-context.xml을 초기화할 떄 쓸 method
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }


    // <servlet>에 설정한 servlet-context.xml을 초기화 할 method
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{ServletConfig.class, MyBatisConfig.class};
    }


    // resources mapping에 설정한 url-pattern 대한 초기화할 method
    @Override
    protected String[] getServletMappings() {
        String[] mapping = new String[]{"/"};
        return mapping;
    }
}
