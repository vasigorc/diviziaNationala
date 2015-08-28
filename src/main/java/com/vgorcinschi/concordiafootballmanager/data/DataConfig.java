/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author vgorcinschi
 *
 */
@Configuration
@EnableTransactionManagement
public class DataConfig {
    /*
     TODO: Add this config to the RootConfig file in the end
     */

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[]{"com.vgorcinschi.concordiafootballmanager.model",
            "com.vgorcinschi.concordiafootballmanager.model.players"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setDataSource(dataSource());
        htm.setSessionFactory(sessionFactory(dataSource()).getObject());
        return htm;
    }
}
