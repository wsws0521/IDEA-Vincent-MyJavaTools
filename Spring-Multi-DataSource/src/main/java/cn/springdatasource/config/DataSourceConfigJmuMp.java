package cn.springdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 使用第三方数据源阿里连接池Druid
 */
@Configuration
@MapperScan(basePackages = "cn.springdatasource.dao.jmuMp", sqlSessionFactoryRef = "sqlSessionFactoryJmuMp")
public class DataSourceConfigJmuMp {
    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private Environment env;

    @Bean(name = "jmuMp")
    @ConfigurationProperties(prefix = "spring.datasource.jmu-mp")
    public DataSource dataSourceJmuMp() {

        // 使用Druid连接池
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(configProperties.getJmuMpUrl());
        ds.setUsername(configProperties.getJmuMpUsername());
        ds.setPassword(configProperties.getJmuMpPassword());

        return ds;
    }

    @Bean(name = "sqlSessionFactoryJmuMp")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("jmuMp") DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);

        fb.setTypeAliasesPackage(env.getProperty("spring.mybatis.typeAliasPackage"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("spring.mybatis.mapper.jmuMp")));

        return fb.getObject();
    }

    @Bean(name = "transactionManagerJmuMp")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("jmuMp") DataSource ds) throws Exception {
        return new DataSourceTransactionManager(ds);
    }
}
