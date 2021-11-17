package com.callor.js.config;

import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    //dataSource
    public DataSource getDataSource() {
        DataSource ds = new BasicDataSource();

        return ds;
    }
}
