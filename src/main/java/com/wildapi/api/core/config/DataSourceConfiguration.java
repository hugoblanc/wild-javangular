package com.wildapi.api.core.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {


    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("wild_db_username"));
        dataSourceBuilder.password(System.getenv("wild_db_password"));
        dataSourceBuilder.url(System.getenv("wild_db_url"));
        
        return dataSourceBuilder.build();
    }

}