package batch;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebListener
public class BoardListener implements ServletContextListener {

	private Scheduler scheduler;
	
	
    public BoardListener() {
        // TODO Auto-generated constructor stub
    	 try {
         	scheduler = new StdSchedulerFactory().getScheduler();
         } catch (Exception e) {
 			e.printStackTrace();
 		}
    	
    }


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
    		if (scheduler != null) {
    			scheduler.shutdown();
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
    		// 1) Top3Job
    		JobDetail job = JobBuilder.newJob(SelectBoardMaxJob.class)
    				.withIdentity("job", "group")
    				.build();
    		// 2) Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger", "group")
    				.withSchedule(CronScheduleBuilder.cronSchedule(""))
    				.build();
    		// 3) scheduler에 job, trigger 등록
    		scheduler.scheduleJob(job, trigger);
    		// 4) scheduler 실행 시작
    		scheduler.start();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	
}
