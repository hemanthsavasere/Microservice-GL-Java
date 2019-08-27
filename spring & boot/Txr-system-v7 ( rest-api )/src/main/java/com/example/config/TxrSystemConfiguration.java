package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(value = { DataSourceConfiguration.class, JpaConfiguration.class, MvcConfiguration.class })
@ComponentScan(basePackages = { "com.example.service", "com.example.repository", "com.example.web" })
@EnableJpaRepositories("com.example.repository")
public class TxrSystemConfiguration {

}
