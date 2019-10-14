package com.example.demo5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner.class);
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "select 1234";
        SqlParameterSource source = new MapSqlParameterSource();
        Integer result = jdbcTemplate.queryForObject(sql, source, Integer.class);
        LOGGER.info("select result:"+result);
    }
}
