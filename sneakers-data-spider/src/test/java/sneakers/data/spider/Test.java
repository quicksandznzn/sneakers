package sneakers.data.spider;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sneakers.data.spider.service.data.DataHandleService;
import sneakers.data.spider.service.spider.SpiderPageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    private static final String url = "http://www.flightclub.cn/release";
    @Autowired
    private DataHandleService dataHandleService;

    @Autowired
    private SpiderPageService spiderPageService;

    @org.junit.Test
    public void test() {
        dataHandleService.insertPageInfo(spiderPageService.spiderFightClubReleasePage(url));
    }

}
