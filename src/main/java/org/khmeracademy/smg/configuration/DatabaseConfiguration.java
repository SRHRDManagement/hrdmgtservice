package org.khmeracademy.smg.configuration;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.mangofactory.swagger.plugin.EnableSwagger;

@Configuration
@MapperScan("org.khmeracademy.smg.repository")
@PropertySource(value = { "classpath:configuration.properties" })
@EnableSwagger
public class DatabaseConfiguration  {
	
//	@Bean 
//	public DataSource getDataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://120.136.24.174:5432/SCHOOL_MGT_SR");
//		dataSource.setUsername("SCHOOL_MGT_SR");
//		dataSource.setPassword("SCHOOL_MGT_SR");
//		return dataSource;
//	}
	
	@Autowired
	private Environment environment;
	
	@Bean 
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("MOL.dataSource.driverClassName"));
		dataSource.setUrl(environment.getProperty("MOL.dataSource.url"));
		dataSource.setUsername(environment.getProperty("MOL.dataSource.username"));
		dataSource.setPassword(environment.getProperty("MOL.dataSource.password"));
		System.out.println("aa");
		return dataSource;
	}
	
	@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

 
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory;
    }
    
/*    @Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(8081);
	    factory.setSessionTimeout(10, TimeUnit.MINUTES);
	    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
	    return factory;
	} */

}
