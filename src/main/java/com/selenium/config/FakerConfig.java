package com.selenium.config;

import com.github.javafaker.Faker;
import com.selenium.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

        @Bean
        public Faker getFaker(){
            return new Faker();
        }
}
