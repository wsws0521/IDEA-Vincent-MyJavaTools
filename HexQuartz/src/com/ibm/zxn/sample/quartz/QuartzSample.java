package com.ibm.zxn.sample.quartz;

import java.util.Date;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;

public class QuartzSample {
	
	public void run() throws Exception
	{
		//ʹ�� StdSchedulerFactory ����һ���µ� Scheduler
		SchedulerFactory sf=new StdSchedulerFactory();
		Scheduler sched=sf.getScheduler();
		//define a job to execute
		JobDetailImpl job=new JobDetailImpl("sampleJob","sampleGroup",SampleJob.class);
		//define a trigger����jobÿ������һ��??
		final CalendarIntervalTriggerImpl trigger=new CalendarIntervalTriggerImpl();
		trigger.setName("sampleTrigger");
		trigger.setStartTime(new Date());
		trigger.setRepeatIntervalUnit(IntervalUnit.MINUTE);
		trigger.setRepeatInterval(2);//�����������Ϊ2min
		//Use scheduler to attach the trigger with job
		sched.scheduleJob(job, trigger);
		//
		sched.start();
		//10 minutes��������
		Thread.sleep(10*60*1000);
		//������ɺ�ɾ��
		//sched.deleteJob("sampleJob");
		sched.shutdown(true);
	}
	public static void main(String[] args) throws Exception
	{
		QuartzSample samp=new QuartzSample();
		samp.run();
	}
}
