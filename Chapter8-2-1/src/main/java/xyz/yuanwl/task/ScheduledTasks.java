package xyz.yuanwl.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务类。
 * @author Yuanwl
 * @date 2018-09-06 17:10:41
 * @version v1.0.0
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        System.out.println("fixedRate-上一次执行开始时间点之后5秒再执行，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    public void fixedDelay() {
        System.out.println("fixedDelay-上一次执行完毕时间点之后5秒再执行，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(initialDelay=1000, fixedRate=5000) // 这里用也可以用fixedDelay等
    public void initialDelay() {
        System.out.println("initialDelay-fixedRate-第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron="*/5 * * * * *")
    public void cron() {
        System.out.println("cron-通过cron表达式定义定时执行规则，当前时间：" + dateFormat.format(new Date()));
    }

}
