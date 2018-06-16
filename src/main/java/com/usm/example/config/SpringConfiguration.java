package com.usm.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfiguration.class)
@ComponentScan("com.usm.example.dao")
public class SpringConfiguration {
}
