package sneakers.data.spider.service.solr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sneakers.common.api.model.PageInfo;
import sneakers.data.spider.repository.SolrHandleRepository;
import sneakers.data.spider.service.solr.SolrHandleService;

@Service
public class SolrHandleServiceImpl implements SolrHandleService {

    @Autowired
    private SolrHandleRepository solrHandleRepository;

    public void savePageInfo(List<PageInfo> list) {
        solrHandleRepository.save(list);
    }

    public void deleteAll() {
        solrHandleRepository.deleteAll();
    }

}