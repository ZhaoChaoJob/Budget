package com.budget.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring Jdbc 配置
 *
 * Created by chao.zhao on 2017/3/13.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringJdbcConfig {

    @Autowired
    public DataSource dataSource ;//数据源

    /**
     * jdbcTemplate 配置
     * @return jdbcTemplate
     */
    @Bean(name = ("jdbcTemplate"))
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate() ;
        jdbcTemplate.setDataSource(dataSource);
       return jdbcTemplate ;
    }

    /**
     * 事务处理
     *
     * @return txManager
     */
    @Bean(name = ("transactionManager"))
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager() ;
        txManager.setDataSource(dataSource);
        return txManager ;
    }
}

