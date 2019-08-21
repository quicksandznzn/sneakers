package sneakers.provider.solr.provider.impl;

import java.util.List;

import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import sneakers.common.api.model.PageInfo;
import sneakers.common.api.provider.SolrHandleProvider;
import sneakers.provider.solr.service.SolrHandleService;

@Service(version = "1.0.0")
public class DubboSolrHandleProviderImpl implements SolrHandleProvider {

    @Autowired
    private SolrHandleService solrHandleService;

    @Override
    public void savePageInfo(List<PageInfo> list) {
        solrHandleService.savePageInfo(list);
    }

    @Override
    public void deleteAll() {
        solrHandleService.deleteAll();
    }

    @Override
    public SolrDocumentList findByTitle(String title, Integer page, Integer size) {
        return solrHandleService.findByTitle(title, page, size);
    }

}
