package com.example.demo5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MyRunner4 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner4.class);
    private String[] namePairs = {"Mark pwd1", "dragon, pwd2", "ken, pwd3", "tim pwd4"};

    @Override
    public void run(String... args) throws Exception {
        List<Object[]> splitUpNames2 = Arrays.asList(namePairs).stream()
                .map(new Function<String, String[]>() {
                    @Override
                    public String[] apply(String s) {
                        return s.split(" ");
                    }
                })
                .collect(Collectors.toList());
                ;
        splitUpNames2.forEach(new Consumer<Object[]>() {
            @Override
            public void accept(Object[] o) {
                LOGGER.info(String.format("record=[%s/%s]", o[0], o[1]));
                LOGGER.info(Arrays.toString(o));
            }
        });
    }
}
