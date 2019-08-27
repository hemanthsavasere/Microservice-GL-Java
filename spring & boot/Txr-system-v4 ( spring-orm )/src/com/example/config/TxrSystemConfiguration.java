package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataSourceConfiguration.class,JpaConfiguration.class})
@ComponentScan(basePackages = { "com.example.service", "com.example.repository" })
public class TxrSystemConfiguration {

}
