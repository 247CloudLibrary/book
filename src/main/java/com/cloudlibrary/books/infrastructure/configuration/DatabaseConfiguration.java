package com.cloudlibrary.books.infrastructure.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:/application.yaml")
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(){ return DataSourceBuilder.create().type(HikariDataSource.class).build(); }

    @Bean
    @ConfigurationProperties(prefix="spring.jpa")
    public Properties hibernateConfig() {
        return new Properties();
    }
}
