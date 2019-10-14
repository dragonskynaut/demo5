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
public class MyRunner2 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner2.class);
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static final String SQL1 = "select :a + :b - :c * :d";
    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("a", 100)
        .addValue("b", 200)
        .addValue("c", 300)
        .addValue("d", 4);
        Integer result = jdbcTemplate.queryForObject(SQL1, parameter, Integer.class);
        LOGGER.info("result= "+result);
    }
}
