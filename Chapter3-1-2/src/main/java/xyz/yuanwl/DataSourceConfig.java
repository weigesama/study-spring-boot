package xyz.yuanwl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Yuanwl
 * @version 1.0.0
 * @date 16/3/26 下午9:11.
 * @blog http://blog.didispace.com
 */
@Configuration
public class DataSourceConfig {

	/*
	 * 用这个注解的bean优先被实例化，并且在后面用@Autowired注入时，如果存在多个类型相同的bean，只会注入这个bean，从而不会引起异常
	 * 也就是说，用了这个注解后，注入时就不需要用@Qualifier区分，这里用这个注解有点多余了，但有时是必须要用的
	 * 详情：https://www.cnblogs.com/MaxElephant/p/8182529.html、https://www.jianshu.com/p/b0644c13a964
	 */
//	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate primaryJdbcTemplate(
			@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate secondaryJdbcTemplate(
			@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
