package cn.springdatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 使用Tomcat自带的的jdbc连接池
 */
@Configuration
@MapperScan(basePackages = "cn.springdatasource.dao.jmuv3", sqlSessionFactoryRef = "sqlSessionFactoryJmuv3")
public class DataSourceConfigJmuv3 {
    @Autowired
    private Environment env;

    @Bean(name = "jmuv3")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.jmuv3")
    public DataSource dataSourceJmuv3() {
        // 使用JDBC数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryJmuv3")
    @Primary
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("jmuv3") DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);

        fb.setTypeAliasesPackage(env.getProperty("spring.mybatis.typeAliasPackage"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("spring.mybatis.mapper.jmuv3")));

        return fb.getObject();
    }

    @Bean(name = "transactionManagerJmuv3")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("jmuv3") DataSource ds) throws Exception {
        return new DataSourceTransactionManager(ds);
    }

}
