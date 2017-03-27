package com.budget.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

/**
 *  替代web.xml
 *
 * Created by chao.zhao on 2017/3/13.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置根配置类
     *
     * @return RootConfig
     */
    @Override
    protected Class<?>[] getRootConfigClasses() { //根容器
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * 重写虚拟方法
     * @return WebConfig
     */
    @Override
    protected Class<?>[] getServletConfigClasses() { //Spring mvc容器
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * 重写虚拟方法
     * @return 访问路径
     */
    @Override
    protected String[] getServletMappings() { //DispatcherServlet映射,从"/"开始
        return new String[] { "/" };
    }

    /**
     * 添加过滤器
     *
     * @return Filter[]
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter() ;
        encodingFilter.setEncoding("UTF-8") ;
        encodingFilter.setForceEncoding(true) ;

//        DelegatingFilterProxy browserFilter = new DelegatingFilterProxy() ;
//        browserFilter.setTargetBeanName("browserFilter");
//
//        DelegatingFilterProxy oAuthUrlFilter = new DelegatingFilterProxy() ;
//        oAuthUrlFilter.setTargetBeanName("OAuthUrlFilter") ;

        return new Filter[] { encodingFilter };
    }

    @Override
    public void onStartup(ServletContext servletContext){
        try{
            super.onStartup(servletContext) ;
        }catch (Exception e){

        }
        Config config = ConfigFactory.load();
        servletContext.setInitParameter("spring.profiles.active", config.getString("springProfiles")) ;
    }
}