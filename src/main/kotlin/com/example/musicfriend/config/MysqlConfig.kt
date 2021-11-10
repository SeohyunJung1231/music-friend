package com.example.musicfriend.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.example.musicfriend.repository"]
)
class MysqlConfig {
    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("com.example.musicfriend.entity")
            .properties(
                mutableMapOf(
                    "hibernate.dialect" to "org.hibernate.dialect.MySQL5Dialect",
                    "hibernate.physical_naming_strategy" to "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy",
                    "hibernate.hbm2ddl.auto" to "create-drop",
                    "hibernate.show-sql" to "true"
                )
            )
            .persistenceUnit("mysqlLocal")
            .build()
    }

    @Bean
    fun transactionManager(
        @Qualifier("entityManagerFactory") entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}