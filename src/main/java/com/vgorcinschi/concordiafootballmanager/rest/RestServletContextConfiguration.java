/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author vgorcinschi
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "com.vgorcinschi.concordiafootballmanager.rest"
)
public class RestServletContextConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public Jackson2ObjectMapperFactoryBean mapper(){
        Jackson2ObjectMapperFactoryBean mapperFactory = new Jackson2ObjectMapperFactoryBean();
        mapperFactory.setAutoDetectFields(false);
        mapperFactory.setAutoDetectGettersSetters(true);
        return mapperFactory;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters
    ) {
        converters.add(new SourceHttpMessageConverter<>());
        MappingJackson2HttpMessageConverter jsonConverter
                = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("application", "json"),
                new MediaType("text", "json")
        ));
        jsonConverter.setObjectMapper(mapper().getObject().setSerializationInclusion(JsonInclude.Include.NON_NULL));
        converters.add(jsonConverter);
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).favorParameter(false)
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }
}
