package com.spain.cvet.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.spain.cvet.repositories")
public class JpaConfiguration {

	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private int maxPoolSize;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	/*
	 * Configure HikariCP pooled DataSource.
	 */
	@Bean
	public DataSource dataSource() {
		final HikariDataSource dataSource = new HikariDataSource();
		DataSourceProperties dataSourceProperties = dataSourceProperties();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setJdbcUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource.setMaximumPoolSize(maxPoolSize);
		return dataSource;
	}

}
