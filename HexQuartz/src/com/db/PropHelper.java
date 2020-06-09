package com.db;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.action.QuartzConfigSave;

public class PropHelper {
	private static String quartzPath = PropHelper.class.getClassLoader().getResource("quartz.properties").getPath();
	public Properties getProp(){		
		File propFile=new File(quartzPath);
		Properties props=new Properties();
		InputStream in=null;
		try {
			if (propFile.exists()){
				in= new BufferedInputStream(new FileInputStream(propFile));
				props.load(in);
			}else{
				ClassLoader cl=getClass().getClassLoader();
				
				in = cl.getResourceAsStream("quartz.properties");
				
				if (in == null){
					in = cl.getResourceAsStream("/quartz.properties");
					}
				if (in == null){
					in = cl.getResourceAsStream("org/quartz/quartz.properties");
					}
				if (in == null){
					
				}
				props.load(in);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			if(in != null){
				try { in.close(); } catch(IOException ignore){}
			}
		}
		return props;
	}
	public void setProps(String instanceName,
						String threadPoolclass,
						String threadCount,
						String jobStoreclass,
						String tablePrefix,
						String driverDelegateClass,
						String dataSource,
						String jdbcName,
						String dbUrl,
						String dbUser,
						String dbPassword) throws IOException{
		FileReader reader = new FileReader(quartzPath);
        Properties props = new Properties();
        props.load(reader);
        props.setProperty("org.quartz.scheduler.instanceName", instanceName);
        props.setProperty("org.quartz.threadPool.class", threadPoolclass);
		props.setProperty("org.quartz.threadPool.threadCount", threadCount);
		props.setProperty("org.quartz.jobStore.class", jobStoreclass);
		props.setProperty("org.quartz.jobStore.tablePrefix", tablePrefix);
		props.setProperty("org.quartz.jobStore.driverDelegateClass", driverDelegateClass);
		props.setProperty("org.quartz.jobStore.dataSource", dataSource);
		props.setProperty("org.quartz.dataSource.sampDS.driver", jdbcName);
		props.setProperty("org.quartz.dataSource.sampDS.URL", dbUrl);
		props.setProperty("org.quartz.dataSource.sampDS.user", dbUser);
		props.setProperty("org.quartz.dataSource.sampDS.password", dbPassword);	
		
        FileWriter writer = new FileWriter(quartzPath);		
		Date d = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d);
        
        props.store(writer, dateNowStr);
		reader.close();
	    writer.close();		
	}
	
}
