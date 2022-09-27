package com.example.reportbuilder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class DatabaseConfig {

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean jackson2RepositoryPopulatorFactoryBean() {
        Jackson2RepositoryPopulatorFactoryBean populatorFactory = new Jackson2RepositoryPopulatorFactoryBean();
        populatorFactory.setResources(new Resource[]{new ClassPathResource("marshal.json")});
        return populatorFactory;
    }

}
