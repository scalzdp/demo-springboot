//package com.example.demo.configure;
//
//import com.example.demo.DemoApplication;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.Validator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;
//
//
//@Configuration
//@ComponentScan(basePackageClasses = DemoApplication.class, includeFilters = @ComponentScan.Filter(Controller.class), useDefaultFilters = false)
//public class WebAppConfigurer extends WebMvcConfigurationSupport {
//    private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
//    private static final String VIEWS = "/WEB-INF/views/";
//
//    private static final String RESOURCES_LOCATION = "/resources/";
//    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";
//
//    //请求url(spring的url)映射到control的配置
//    @Override
//    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
//        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
//        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
//        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
//        return requestMappingHandlerMapping;
//    }
//
//    //messageSource国际化
//    @Bean(name="messageSource")
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(MESSAGE_SOURCE);
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(5);
//        return messageSource;
//    }
//
//    //模板解析器
//    @Bean
//    public TemplateResolver templateResolver(){
//        TemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix(VIEWS);
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
//    //Spring的模板引擎
//    @Bean
//    public SpringTemplateEngine templateEngine(){
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
////        templateEngine.addDialect(new SpringSecurityDialect());
//        return templateEngine;
//    }
//
//    //ThymeleafViewResolver页面解析器
//    @Bean
//    public ThymeleafViewResolver viewResolver(){
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
//        thymeleafViewResolver.setCharacterEncoding("UTF-8");
//        return thymeleafViewResolver;
//    }
//
//    @Override
//    public Validator getValidator(){
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.setValidationMessageSource(messageSource());
//        return  validator;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//}
