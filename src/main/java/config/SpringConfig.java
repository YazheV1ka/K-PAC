package config;

import dao.KPacDao;
import dao.KPacDaoImpl;
import dao.SetDao;
import dao.SetDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.KPacService;
import service.KPacServiceImpl;
import service.SetService;
import service.SetServiceImpl;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan(basePackages = {"dao","service"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
    @Autowired
    private Environment env;
    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("com.mysql.cj.jdbc.Driver")));
        dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3306/k-pac"));
        dataSource.setUsername(env.getProperty("root"));
        dataSource.setPassword(env.getProperty("28Vika200413"));
        return dataSource;
    }

    @Bean
    public KPacDao getKPacDao(){
        return new KPacDaoImpl(getJdbcTemplate());
    }

    @Bean
    public SetDao getSetDao(){return new SetDaoImpl(getJdbcTemplate());}

    @Bean
    public KPacService getKPacService(){return new KPacServiceImpl();}

    @Bean
    public SetService getSetService(){return new SetServiceImpl();}
}
