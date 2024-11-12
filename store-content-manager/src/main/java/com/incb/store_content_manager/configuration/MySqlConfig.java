package com.incb.store_content_manager.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com/incb/store_content_manager/repository/mysql",
        entityManagerFactoryRef = "sqlEntityManagerFactory",
        transactionManagerRef = "sqlTransactionManager"
)
@ConditionalOnProperty(prefix = "db.source", value = "type", havingValue = "mysql")
@Slf4j
public class MySqlConfig {

    @Value("${db.source.type}")
    private String dbSourceType;

    @PostConstruct
    public void init() {
        log.info("db.source.type: {}", dbSourceType);
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    @Lazy
    public DataSource dataSourceBuild() {
        log.info("MySQL DataSource bean is being created...");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceBuild())
                .packages("com.incb.store_content_manager.model.MySqlEntities")
                .persistenceUnit("mysql")
                .build();
    }

    @Bean(name = "sqlTransactionManager")
    public PlatformTransactionManager sqlTransactionManager(@Qualifier("sqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
