package test;

import static org.quartz.TriggerKey.triggerKey;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.SchedulerRepository;
import org.quartz.impl.StdSchedulerFactory;

import com.db.PropHelper;

public class GetScheduler {
	public String GetSched() throws SchedulerException{
//		SchedulerRepository SR = null;
//		Scheduler sched=SR.lookup("QuartzScheduler");
//		return sched;
		StdSchedulerFactory sf = new StdSchedulerFactory();
		
		Properties props = new PropHelper().getProp();
		props.put("org.quartz.scheduler.instanceName", "fuck");
		//props.put("org.quartz.threadPool.threadCount", "10");//#必填
		sf.initialize(props);
		
		Scheduler sched = sf.getScheduler();
		//按名称查询
	    //Scheduler sched1 = sf.getScheduler("QuartzScheduler");
	    //查询所有		    
	    Collection<Scheduler>  sss=SchedulerRepository.getInstance().lookupAll();
	    System.out.println("调度器集合："+sss);
	    System.out.println("调度器名称："+sched.getSchedulerName());
	    //System.out.println(sched1.getSchedulerName()+sched1.getSchedulerInstanceId());
	    //sched.start();
	    return "hah";
	    
	}
	

	public static void main(String[] args) throws SchedulerException {
		// TODO 自动生成的方法存根
		System.out.println(new GetScheduler().GetSched());
	}

}
