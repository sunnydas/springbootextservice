package com.sunny.currencyconversion.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sunny.currency.conversion.rest")
public class CurrencyConversionApplication {


    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class,args);
    }

}
