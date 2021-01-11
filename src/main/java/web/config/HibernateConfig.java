package web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

//@Configuration
//@ComponentScan(basePackages = "web")
//@EnableTransactionManagement
//@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {
    private Environment environment;

//    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

//    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

//    @Bean
    public DataSource dataSource() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        return dataSource;
    }

//    @Bean
    public JpaTransactionManager jpaTransactionManager() throws SQLException {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory(dataSource(), hibernateProperties()));
        return jpaTransactionManager;
    }

//    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        final LocalContainerEntityManagerFactoryBean lcefb = new LocalContainerEntityManagerFactoryBean();
        lcefb.setDataSource(dataSource);
        lcefb.setPackagesToScan("web");
        lcefb.setJpaProperties(hibernateProperties());
        lcefb.setPersistenceUnitName("emf");
        lcefb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lcefb.afterPropertiesSet();
        return lcefb.getObject();
    }
}
