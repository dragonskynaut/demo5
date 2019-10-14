package com.example.demo5;

import com.example.demo5.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MyRunner5 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner5.class);
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static final String DML1 = "select id, username, password from user2 where id=:id";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("id", 1);
        User user = jdbcTemplate.queryForObject(DML1, parameter, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")));
        LOGGER.info(user.toString());
    }
}
