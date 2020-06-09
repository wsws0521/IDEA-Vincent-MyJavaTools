package test;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;

public class CronValidity {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(getCronSchedule("2 * * * * ?"));
	}
	
	public static String getCronSchedule(String cron)
	{
		String timeSchedule="";
		if(!CronExpression.isValidExpression(cron)){
			return "Cron is invalid...";
		}
		try{
			//CronTrigger trigger = newTrigger().withIdentity("Caclulate Date").withSchedule(cronSchedule(cron)).build();
		    // schedule it to run!
			CronTrigger trigger=newTrigger().withIdentity("Caclulate Date").withSchedule(cronSchedule(cron)).build();
			Date time0=trigger.getStartTime();
			Date time1=trigger.getFireTimeAfter(time0);
			Date time2=trigger.getFireTimeAfter(time1);
			Date time3=trigger.getFireTimeAfter(time2);
			Date time4=trigger.getFireTimeAfter(time3);
			Date time5=trigger.getFireTimeAfter(time4);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuilder timeBuilder=new StringBuilder();
			timeBuilder
			.append(format.format(time1))
			.append("\n")
			.append(format.format(time2))
			.append("\n")
			.append(format.format(time3))
			.append("\n")
			.append(format.format(time4))
			.append("\n")
			.append(format.format(time5));
			timeSchedule=timeBuilder.toString();
		}
		catch(Exception e){
			timeSchedule="unknow time";
		}
		return timeSchedule;		
	}

}
