package sneakers.data.spider.service.data.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;

import sneakers.common.api.model.PageInfo;
import sneakers.common.api.provider.SolrHandleProvider;
import sneakers.data.spider.service.data.DataHandleService;

@Service
@Transactional(rollbackFor = Exception.class)
public class DataHandleServiceImpl implements DataHandleService {

    private static final Logger LOG = LoggerFactory.getLogger(DataHandleServiceImpl.class);

    @Reference(version = "1.0.0")
    private SolrHandleProvider solrHandleProvider;

    @Override
    public void insertPageInfo(List<PageInfo> pageInfoList) {
        solrHandleProvider.deleteAll();// beacuse i just want latest data so ....
        solrHandleProvider.savePageInfo(pageInfoList);
        LOG.info("==================== TASK FIGHTCLOUD END====================");
    }

}
