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
		//props.put("org.quartz.threadPool.threadCount", "10");//#����
		sf.initialize(props);
		
		Scheduler sched = sf.getScheduler();
		//�����Ʋ�ѯ
	    //Scheduler sched1 = sf.getScheduler("QuartzScheduler");
	    //��ѯ����		    
	    Collection<Scheduler>  sss=SchedulerRepository.getInstance().lookupAll();
	    System.out.println("���������ϣ�"+sss);
	    System.out.println("���������ƣ�"+sched.getSchedulerName());
	    //System.out.println(sched1.getSchedulerName()+sched1.getSchedulerInstanceId());
	    //sched.start();
	    return "hah";
	    
	}
	

	public static void main(String[] args) throws SchedulerException {
		// TODO �Զ����ɵķ������
		System.out.println(new GetScheduler().GetSched());
	}

}
