package com.github.selenium;

import org.springframework.boot.SpringApplication;

@SuppressWarnings("squid:S1118")
public class Main {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Main.class, args).close();
    }
}
