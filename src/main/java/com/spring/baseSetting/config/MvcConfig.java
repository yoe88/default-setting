package com.spring.baseSetting.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc //mvc:annotation-driven
@ComponentScan(basePackages = {"com.spring.baseSetting.controller"}) //<context:component-scan/>
public class MvcConfig implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public MvcConfig() {
        logger.info("MvcConfig Init...");
    }

    //servlet-context
    //스프링이 처리하지 못한 경로에 대한 처리는 디폴트 서블릿에게 전달하여 처리하게 된다.
    //정적 자원과 같은 특정 요청에 대해 컨테이너의 기본 서블릿을 사용하도록 Spring에 지시한다.
    //default servlet handler를 사용하게 .
    //<mvc:default-servlet-handler>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // Spring MVC에서 jsp view 가 위치하는 경로를 설정한다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");

        //타일즈 사용 하는 경우
        /*TilesViewResolver resolver = new TilesViewResolver();
        registry.viewResolver(resolver);
        resolver.setOrder(1);*/
    }

    //    '/' 로 요청이 오면 '/index'으로 리다이렉트
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index");
    }

    //  /resources 경로에 있는 자료들을 /resources/별별로 접근하게 합니다.
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    //타일즈 사용 하는 경우
    /*@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions("classpath:tiles/*.xml");
        configurer.setCheckRefresh(true);
        return configurer;
    }*/

    //파일 업로드
    /*@Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(10485760);  //한 파일당 업로드가 허용되는 최대 용량 바이트 단위 10mb
        resolver.setMaxUploadSize(52428800); //한 요청당 업로드가 허용되는 최대 용량 바이트 단위  50mb
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }*/
}
