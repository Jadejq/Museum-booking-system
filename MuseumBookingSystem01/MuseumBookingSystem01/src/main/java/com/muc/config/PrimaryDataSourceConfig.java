//package com.muc.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
///**
// * @author 朱佳琦
// * @version 1.0
// */
//@Configuration
//@MapperScan(basePackages = "com.muc.mapper", sqlSessionFactoryRef = "primarySqlSessionFactory")
//public class PrimaryDataSourceConfig {
//    @Primary
//    @Bean(name = "primarySqlSessionFactory")
//    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("dataSourceAll") DataSource dataSource, ApplicationContext applicationContext)throws  Exception{
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/muc/mapper/*.xml"));
////        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return bean.getObject();
//    }
//    @Primary
//    @Bean(name = "primarySqlSessionTemplate")
//    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
