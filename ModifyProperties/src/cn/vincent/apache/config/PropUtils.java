package cn.vincent.apache.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;

import java.io.*;

public class PropUtils {
    private static PropUtils _instance = null;
    private static PropertiesConfiguration config = new PropertiesConfiguration();
    private static PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
    private static final String CONFIG_FILE = "D:\\Program Files\\JetBrains\\IdeaProjects\\MyJavaTools\\ModifyProperties\\res\\uap.properties";
    static {
        _instance = new PropUtils();
        _instance.loadConfig(CONFIG_FILE);
    }

    public void loadConfig(final String fileName){
        try {
            layout.load(config, new InputStreamReader(new FileInputStream(fileName)));
        } catch (ConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getStringConfig(final String key){
        return config.getString(key);
    }
    public static void addOrUpdateStringConfig(final String key, final String value){
        config.setProperty(key, value);
        persistConfig();
    }
    public static void persistConfig(){
        try {
            FileWriter out = new FileWriter(CONFIG_FILE, false);
            layout.save(config, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//<!-- https://mvnrepository.com/artifact/commons-configuration/commons-configuration -->
//<dependency>
//    <groupId>commons-configuration</groupId>
//    <artifactId>commons-configuration</artifactId>
//    <version>1.10</version>
//</dependency>

}
