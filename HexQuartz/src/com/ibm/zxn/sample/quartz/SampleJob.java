package com.ibm.zxn.sample.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

public class SampleJob implements StatefulJob
{
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		Date dt=new Date();
		String time=dt.toString();
		System.out.println(time+":SampleJob is Started!");
		try
		{
			Thread.sleep(10*1000);
		}
		catch (Exception e){}
	}
}
