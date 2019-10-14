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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyRunner3 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner3.class);
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String DDL0 = "drop table users if exists";
    private static final String DDL1 = "create table " +
            "users(id serial, username varchar(255), password varchar(255))";
    // add 2 columns
    private static String col1="username";
    private static String col2="password";
    private static final String DML1 = "insert into users("+ col1 +","+col2+") values(?,?)";
    private String[] namePairs = {"Mark pwd1", "dragon pwd2", "ken pwd3", "tim pwd4"};
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute(DDL0);
        jdbcTemplate.execute(DDL1);
        LOGGER.info("========excute DDL finished========");
        List<Object[]> splitNames = Arrays.asList(namePairs).stream()
            .map(userString->userString.split(" "))
            .collect(Collectors.toList());
        splitNames.forEach(t1->LOGGER.info(String.format("insert [%s,%s]", t1[0], t1[1])));
        // template can batch update
        LOGGER.info("------batch update-------");
        jdbcTemplate.batchUpdate(DML1, splitNames);
    }
}
