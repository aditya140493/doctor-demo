package com.doctor.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.doctor.model")
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")

public class MyConfiguration {
	
	@Autowired
    private Environment environment;
	
	@Autowired
	 private SessionFactory sessionFactory;
//	@Bean
//	public InternalResourceViewResolver m1()
//	{
//		InternalResourceViewResolver i=new InternalResourceViewResolver();
//		i.setPrefix("/WEB-INF/pages/");
//		i.setSuffix(".jsp");
//		return i;
//	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean l=new LocalSessionFactoryBean();
		l.setPackagesToScan(new String[] {"com.doctor.model"});
		l.setDataSource(dataSource());
		l.setHibernateProperties(properties());
		return l;
	}
	/*@Bean
	public JavaMailSenderImpl mailSender()
	{
		JavaMailSenderImpl j=new JavaMailSenderImpl();
		j.setPort(587);
		j.setHost("smtp.gmail.com");
		j.setUsername(environment.getRequiredProperty("email.username"));
		j.setPassword(environment.getRequiredProperty("email.password"));
		j.setJavaMailProperties(emailProperties());
		return j;
	}
	private Properties emailProperties() {
		// TODO Auto-generated method stub
		Properties p=new Properties();
		p.setProperty("mail.transport.properties", "smtp");
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		return p;
		
	}*/
	
	
	@Bean
	 public JdbcTemplate getjdbcTemplate() {
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
	  return jdbcTemplate;
	 }

	 @Bean
	 public HibernateTemplate hibernateTemplate() {

	  HibernateTemplate hibernateTemplate = new HibernateTemplate();

	  hibernateTemplate.setSessionFactory(sessionFactory);

	  return hibernateTemplate;
	 }

//	 @Bean
//	 public LocalSessionFactoryBean sessionFactory() {
//	  LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//	  sessionFactory.setDataSource(dataSource());
//	  sessionFactory.setPackagesToScan(new String[] { "com.omfys.remittance.model" });
//	  sessionFactory.setHibernateProperties(hibernateProperties());
//	  return sessionFactory;
//	 }
	
	
	private DataSource dataSource() {
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		d.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		d.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		d.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return d;
	}
	private Properties properties() {
		Properties p=new Properties();
		p.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("h.hbm"));
		p.setProperty("hibernate.dialect", environment.getRequiredProperty("h.d"));
		p.setProperty("hibernate.show_sql", environment.getRequiredProperty("h.s"));
		return p;
	}
	@Autowired
	@Bean
	public HibernateTransactionManager txManger(SessionFactory s)
	{
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(s);
		return tx;
	}

}
