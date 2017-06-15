package sneakers.data.spider.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sneakers.common.api.model.PageInfo;
import sneakers.data.spider.service.data.DataHandleService;
import sneakers.data.spider.service.solr.SolrHandleService;

@Service
@Transactional(rollbackFor = Exception.class)
public class DataHandleServiceImpl implements DataHandleService {

    @Autowired
    private SolrHandleService solrHandleService;

    @Override
    public void insertPageInfo(List<PageInfo> pageInfoList) {
        solrHandleService.deleteAll();// beacuse i just want latest data so ....
        solrHandleService.savePageInfo(pageInfoList);
    }

}
