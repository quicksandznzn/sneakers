package sneakers.data.spider.service.task.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import sneakers.data.spider.service.data.DataHandleService;
import sneakers.data.spider.service.spider.SpiderPageService;
import sneakers.data.spider.service.task.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private DataHandleService dataHandleService;

    @Autowired
    private SpiderPageService spiderPageService;

    @Value("${fightclub_release_url}")
    private String FIGHTCLUB_RELEASE_URL;

    @Scheduled(cron = "0 0 1 * * ?") // 每天凌晨1点执行
    @Override
    public void taskFightCloudPage() {
        LOG.info("==================== TASK FIGHTCLOUD START====================");

        dataHandleService.insertPageInfo(
                spiderPageService.spiderFightClubReleasePage(FIGHTCLUB_RELEASE_URL));

    }

}
