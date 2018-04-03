package com.bellinfo.password.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
@ComponentScan(basePackages= {"com.bellinfo"})
@EnableWebMvc
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Welcome12#");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbctemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver ubvr = new UrlBasedViewResolver();
		ubvr.setOrder(0);
		ubvr.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
		return ubvr;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tc = new TilesConfigurer();
		String[] definitions = new String[]{
	            "WEB-INF/tiles.xml"
	    };
		tc.setDefinitions(definitions);
		return tc;
		}
		
		
}
