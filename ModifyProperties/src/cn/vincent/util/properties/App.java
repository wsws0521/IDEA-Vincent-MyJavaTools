package cn.vincent.util.properties;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class App {
    private static final String APP_PATH = "/app.properties";
    private static final String CHARSET = "UTF-8";

    private static String DEFAULT_UAP_CONFIG_PATH;
    private static String DEFAULT_MDC_CONFIG_PATH;
    private static String DEFAULT_IP;
    private static String DEFAULT_DB_TYPE;
    private static String DEFAULT_DB_NAME;
    private static String DEFAULT_DB_USERNAME;
    private static String DEFAULT_DB_PASSWORD;

    public static void main(String[] args) {
//        读取默认配置
        readDefaultConfig();
        Scanner scanner = new Scanner(System.in);
//        输入ip
        System.out.println("请输入IP");
        String inputIp = scanner.nextLine();
        if ("".equals(inputIp)) {
            System.out.println("使用默认IP：" + DEFAULT_IP);
            inputIp = DEFAULT_IP;
        }
//        输入数据库类型
        System.out.println("请选择数据库类型：1-oracle 2-MySQL");
        String inputDbType = scanner.nextLine();
        if ("".equals(inputDbType) || (!"1".equals(inputDbType) && !"2".equals(inputDbType))) {
            System.out.println("使用默认数据库类型：" + DEFAULT_DB_TYPE);
            inputDbType = DEFAULT_DB_TYPE;
        }
        //        MySQL需要输入数据库实例名
        String inputDbName = "orcl";
        if ("2".equals(inputDbType)) {
            System.out.println("请输入数据库实例名");
            inputDbName = scanner.nextLine();
            if ("".equals(inputDbName)) {
                System.out.println("使用默认数据库名称：" + DEFAULT_DB_NAME);
                inputDbType = DEFAULT_DB_NAME;
            }
        }
//        输入数据库用户名
        System.out.println("请输入数据库用户名");
        String inputDbUsername = scanner.nextLine();
        if ("".equals(inputDbUsername)) {
            System.out.println("使用默认数据库用户名：" + DEFAULT_DB_USERNAME);
            inputDbUsername = DEFAULT_DB_USERNAME;
        }
        //        输入数据库密码
        System.out.println("请选择数据库密码");
        String inputDbPassword = scanner.nextLine();
        if ("".equals(inputDbPassword)) {
            System.out.println("使用默认数据库密码：" + DEFAULT_DB_PASSWORD);
            inputDbPassword = DEFAULT_DB_PASSWORD;
        }
        //执行修改
        modifyProp(inputIp, inputDbType, inputDbName, inputDbUsername, inputDbPassword);
        System.out.println("修改完成！");
    }

    private static void readDefaultConfig() {
        Properties prop = new Properties();
        try {
            // 项目的res下属于相对路径，getResourceAsStream方法适用
            // 前缀 System.getProperty("user.dir"); 全路径
            prop.load(new InputStreamReader(Object.class.getResourceAsStream(APP_PATH), CHARSET));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DEFAULT_UAP_CONFIG_PATH = prop.getProperty("defaultUapConfigPath");
        DEFAULT_MDC_CONFIG_PATH = prop.getProperty("defaultMdcConfigPath");
        DEFAULT_IP = prop.getProperty("defaultIp");
        DEFAULT_DB_TYPE = prop.getProperty("defaultDbType");
        DEFAULT_DB_NAME = prop.getProperty("defaultDbName");
        DEFAULT_DB_USERNAME = prop.getProperty("defaultDbUserName");
        DEFAULT_DB_PASSWORD = prop.getProperty("defaultDbPassword");
    }

    private static void modifyProp(String ip, String dbType, String dbName, String userName, String passWord) {
        Properties prop = new Properties();

        // 保存
        try {
            // 项目外的路径属于绝对路径，File类适用
            prop.load(new FileReader(new File(DEFAULT_UAP_CONFIG_PATH)));
            if ("1".equals(dbType)) {
                // oracle数据库
                prop.setProperty("spring.datasource.url", "oracle-654321");
            } else if ("2".equals(dbType)) {
                // MySQL数据库
                prop.setProperty("spring.datasource.url", "MySQL-654321");
            }
            FileWriter fwUap = new FileWriter(new File(DEFAULT_UAP_CONFIG_PATH));
            prop.store(fwUap, "保存uap修改");

            prop.clear();
            prop.load(new FileReader(new File(DEFAULT_MDC_CONFIG_PATH)));
            if ("1".equals(dbType)) {
                // oracle数据库
                prop.setProperty("spring.datasource.url", "oracle-654321");
            } else if ("2".equals(dbType)) {
                // MySQL数据库
                prop.setProperty("spring.datasource.url", "MySQL-654321");
            }
            FileWriter fwMdc = new FileWriter(new File(DEFAULT_MDC_CONFIG_PATH));
            prop.store(fwMdc, "保存mdc修改");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*enum DbType{
        ORACLE(1),
        MYSQL(2);

        private int value;

        private DbType(int value) {
            this.value = value;
        }
    }*/
}
