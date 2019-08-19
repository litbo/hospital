package com.litbo.hospital.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.config
 * @Author: looli
 * @CreateTime: 2019-07-25 15:04
 * @Description: todo
 */
@Configuration
@MapperScan(basePackages = "com.litbo.hospital.operational_data_monitoring.software_interface.mapper",
        sqlSessionTemplateRef = "SqlSessionTemplate2")
public class MybatisConfigTwo {
    @Value("${spring.datasource.two.url}")
    private String url;

    @Value("${spring.datasource.two.username}")
    private String user;

    @Value("${spring.datasource.two.password}")
    private String password;

    @Value("${spring.datasource.two.driverClassName}")
    private String driverClass;

    @Bean(name = "dataSourceTwo")
    public DataSource dataSourceTwo() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSourceOneTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceTwo());
    }

    @Bean(name = "SqlSessionFactory2")
    public SqlSessionFactory getSqlSessionFactory2(@Qualifier("dataSourceTwo") DataSource dataSourceTwo)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceTwo);
        return sessionFactory.getObject();
    }

    @Bean(name = "SqlSessionTemplate2")
    public SqlSessionTemplate getSqlSessionTemplate2(
            @Qualifier("SqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
