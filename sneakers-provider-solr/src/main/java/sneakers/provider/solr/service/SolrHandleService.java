package sneakers.provider.solr.service;

import java.util.List;

import org.apache.solr.common.SolrDocumentList;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleService {

    void savePageInfo(List<PageInfo> list);

    void deleteAll();

    SolrDocumentList findByTitle(String title, Integer page, Integer size);

}
