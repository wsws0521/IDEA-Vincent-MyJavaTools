package cn.vincent.quartz.job;


import cn.vincent.service.DbService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 创建 ScheduledJob.java 并实现Job接口，它是我们之后任务被调度后执行业务逻辑的主要类，通过execute()方法执行
 */
public class ScheduledJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);
    @Autowired
    DbService dbService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("........................开始执行同步任务........................");
        dbService.generalCall();
        logger.info("------------------------执行同步任务完成------------------------");
    }
}
