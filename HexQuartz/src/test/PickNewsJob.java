package test;//package test;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.quartz.Job;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.SimpleTrigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.impl.StdSchedulerFactory;
//
////import static org.quartz.JobBuilder.*;
//
//public class PickNewsJob implements Job {
//
//	public static void main(String[] args) {
//		JobDetail jobDetail = JobBuilder.newJob(PickNewsJob.class)
//                .withIdentity("job1", "jgroup1").build();
//        SimpleTrigger simpleTrigger = TriggerBuilder
//                .newTrigger()
//                .withIdentity("trigger1")
//                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 2))
//                .startNow()
//                .build();
//
//        //����scheduler
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler;
//		try {
//			scheduler = schedulerFactory.getScheduler();
//			scheduler.scheduleJob(jobDetail, simpleTrigger);
//	        scheduler.start();
//		} catch (SchedulerException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}        
//	}
//
//	@Override
//	public void execute(JobExecutionContext context) throws JobExecutionException {
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        System.out.println("��"+sdf.format(new Date())+"��ȡ����");
//	}
//
//}
