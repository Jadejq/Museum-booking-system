//package com.muc.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
///**
// * @author 朱佳琦
// * @version 1.0
// */
//@Configuration
//@EnableTransactionManagement
//public class DataSourceConfig {
//    @Primary
//    @Bean(name = "dataSourceAll")
//    @ConfigurationProperties(prefix = "spring.datasource.all")
//    public DataSource dataSourceAll() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "dataSourceUser")
//    @ConfigurationProperties(prefix = "spring.datasource.user")
//    public DataSource dataSourceUser() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "dataSourceAdmin")
//    @ConfigurationProperties(prefix = "spring.datasource.admin")
//    public DataSource dataSourceAdmin() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//}
//
