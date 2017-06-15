package sneakers.data.spider.service.solr;

import java.util.List;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleService {

    void savePageInfo(List<PageInfo> list);

    void deleteAll();
}
