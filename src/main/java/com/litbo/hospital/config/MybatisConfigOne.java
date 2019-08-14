package com.litbo.hospital.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.config
 * @Author: looli
 * @CreateTime: 1019-07-15 15:04
 * @Description: todo
 */
@Configuration
@MapperScan(basePackages = {
        "com.litbo.hospital.beneficial.dao",
        "com.litbo.hospital.common.dao",
        "com.litbo.hospital.common.task.dao",
        "com.litbo.hospital.lifemanage.dao",
        "com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao",
        "com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.dao",
        "com.litbo.hospital.security.dao",
        "com.litbo.hospital.supervise.dao",
        "com.litbo.hospital.user.dao",
        "com.litbo.hospital.operational_data_monitoring.software_interface.dao",
        "com.litbo.hospital.operational_data_monitoring.software_interface.timedtask",
        "com.litbo.hospital.security.specialequipment.dao"},
        sqlSessionTemplateRef = "SqlSessionTemplate1")
public class MybatisConfigOne {


    @Value("${spring.datasource.one.url}")
    private String url;

    @Value("${spring.datasource.one.username}")
    private String user;

    @Value("${spring.datasource.one.password}")
    private String password;

    @Value("${spring.datasource.one.driverClassName}")
    private String driverClass;

    @Bean(name = "dataSourceOne")
    @Primary
    public DataSource dataSourceOne() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSourceOneTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceOne());
    }
    @Bean(name = "SqlSessionFactory1")
    @Primary
    public SqlSessionFactory getSqlSessionFactory1(@Qualifier("dataSourceOne") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:com/litbo/hospital/security/specialequipment/dao/*.xml")
        );
        return sessionFactory.getObject();
    }

    @Bean(name = "SqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate1(
            @Qualifier("SqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
