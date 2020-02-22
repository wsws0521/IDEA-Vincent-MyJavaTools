package cn.springdatasource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 把配置文件封装到bean并注入spring容器
 */
@Component
@PropertySource("file:/var/opt/spring-boot-test/config.properties")
public class ConfigProperties {
    @Value("${spring.datasource.jmuv3.jdbc-url}")
    private String jmuv3Url;

    @Value("${spring.datasource.jmuv3.driver-class-name}")
    private String jmuv3DriverClassName;

    @Value("${spring.datasource.jmuv3.username}")
    private String jmuv3Username;

    @Value("${spring.datasource.jmuv3.password}")
    private String jmuv3Password;

    @Value("${spring.datasource.ccjoin-settlement.jdbc-url}")
    private String ccjoinSettlementUrl;

    @Value("${spring.datasource.ccjoin-settlement.driver-class-name}")
    private String ccjoinSettlementDriverClassName;

    @Value("${spring.datasource.ccjoin-settlement.username}")
    private String ccjoinSettlementUsername;

    @Value("${spring.datasource.ccjoin-settlement.password}")
    private String ccjoinSettlementPassword;

    @Value("${spring.datasource.ccjoin-settlement.type}")
    private String ccjoinSettlementType;

    @Value("${spring.datasource.jmu-mp.jdbc-url}")
    private String jmuMpUrl;

    @Value("${spring.datasource.jmu-mp.driver-class-name}")
    private String jmuMpDriverClassName;

    @Value("${spring.datasource.jmu-mp.username}")
    private String jmuMpUsername;

    @Value("${spring.datasource.jmu-mp.password}")
    private String jmuMpPassword;


    public String getJmuv3Url() {
        return jmuv3Url;
    }

    public void setJmuv3Url(String jmuv3Url) {
        this.jmuv3Url = jmuv3Url;
    }

    public String getJmuv3DriverClassName() {
        return jmuv3DriverClassName;
    }

    public void setJmuv3DriverClassName(String jmuv3DriverClassName) {
        this.jmuv3DriverClassName = jmuv3DriverClassName;
    }

    public String getJmuv3Username() {
        return jmuv3Username;
    }

    public void setJmuv3Username(String jmuv3Username) {
        this.jmuv3Username = jmuv3Username;
    }

    public String getJmuv3Password() {
        return jmuv3Password;
    }

    public void setJmuv3Password(String jmuv3Password) {
        this.jmuv3Password = jmuv3Password;
    }

    public String getCcjoinSettlementUrl() {
        return ccjoinSettlementUrl;
    }

    public void setCcjoinSettlementUrl(String ccjoinSettlementUrl) {
        this.ccjoinSettlementUrl = ccjoinSettlementUrl;
    }

    public String getCcjoinSettlementDriverClassName() {
        return ccjoinSettlementDriverClassName;
    }

    public void setCcjoinSettlementDriverClassName(String ccjoinSettlementDriverClassName) {
        this.ccjoinSettlementDriverClassName = ccjoinSettlementDriverClassName;
    }

    public String getCcjoinSettlementUsername() {
        return ccjoinSettlementUsername;
    }

    public void setCcjoinSettlementUsername(String ccjoinSettlementUsername) {
        this.ccjoinSettlementUsername = ccjoinSettlementUsername;
    }

    public String getCcjoinSettlementPassword() {
        return ccjoinSettlementPassword;
    }

    public void setCcjoinSettlementPassword(String ccjoinSettlementPassword) {
        this.ccjoinSettlementPassword = ccjoinSettlementPassword;
    }

    public String getCcjoinSettlementType() {
        return ccjoinSettlementType;
    }

    public void setCcjoinSettlementType(String ccjoinSettlementType) {
        this.ccjoinSettlementType = ccjoinSettlementType;
    }

    public String getJmuMpUrl() {
        return jmuMpUrl;
    }

    public void setJmuMpUrl(String jmuMpUrl) {
        this.jmuMpUrl = jmuMpUrl;
    }

    public String getJmuMpDriverClassName() {
        return jmuMpDriverClassName;
    }

    public void setJmuMpDriverClassName(String jmuMpDriverClassName) {
        this.jmuMpDriverClassName = jmuMpDriverClassName;
    }

    public String getJmuMpUsername() {
        return jmuMpUsername;
    }

    public void setJmuMpUsername(String jmuMpUsername) {
        this.jmuMpUsername = jmuMpUsername;
    }

    public String getJmuMpPassword() {
        return jmuMpPassword;
    }

    public void setJmuMpPassword(String jmuMpPassword) {
        this.jmuMpPassword = jmuMpPassword;
    }
}
