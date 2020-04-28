package com.salon.config;

import com.salon.datasourcebeans.MySqlDataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Slf4j
@Configuration
@PropertySources({
        @PropertySource("classpath:mysql.properties")
})
public class PropertyConfig {

    @Value("${spring.datasource.username}")
    private String userMySql;

    @Value("${mysql.password}")
    private String passwordMySql;

    @Value("${mysql.url}")
    private String urlMySql;


    @Bean
    public MySqlDataSource mySqlDataSource(){
        //System.out.println(">>>>>>>>>>>>MySqlDataSource" + userMySql);
        MySqlDataSource mySqlDataSource=new MySqlDataSource();
        mySqlDataSource.setUsername(userMySql);
        mySqlDataSource.setPassword(passwordMySql);
        mySqlDataSource.setUrl(urlMySql);
        log.info("MySqlDataSource is created!!!");
        return mySqlDataSource;
    }

    //static !!!VERY IMPORTANT !!!//
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
