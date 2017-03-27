package com.budget.config;

import org.springframework.context.annotation.*;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * 根配置类
 *
 * Created by chao.zhao on 2017/3/13.
 */
@Configuration
@ComponentScan(basePackages = {"com.budget"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@Import(SpringJdbcConfig.class)
public class RootConfig {

    @Bean(name = ("dataSource"))
    public DataSource dataSource(){
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean() ;
        bean.setJndiName("jdbc/wcb") ;
        try{
            bean.afterPropertiesSet() ;
        }catch (Exception e){

        }
        return (DataSource)bean.getObject() ;
    }
}
