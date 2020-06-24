package com.spring.baseSetting.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//web.xml을 대신한다.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public WebConfig() {
        logger.info("WebConfig Init...");
    }

    // Spring Config 파일을 설정한다.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    // Spring MVC(WEB) Config 파일을 설정한다. MVC Config는 Bean을 RootConfig에서 설정한 곳에서부터 찾는다.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    // DispatcherServlet이 매핑되기 위한 경로를 지정한다.
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    //인코딩 필터 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }
}