package com.example.demo5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MyRunner3 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner3.class);
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String DDL1 = "create table " +
            "demo1(id serial, username varchar(255), password varchar(255))";
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute(DDL1);
        LOGGER.info("run create table");
    }
}
