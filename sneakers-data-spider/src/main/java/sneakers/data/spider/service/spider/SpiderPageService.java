package sneakers.data.spider.service.spider;

import java.util.List;

import sneakers.common.api.model.PageInfo;


public interface SpiderPageService {

    List<PageInfo> spiderFightClubReleasePage(String url);
}
