package com.app.invoices.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Log
public class DataBaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){
        System.out.println("dataSource : " + dataSource.toString());
        return new JdbcTemplate(dataSource);
    }
}
