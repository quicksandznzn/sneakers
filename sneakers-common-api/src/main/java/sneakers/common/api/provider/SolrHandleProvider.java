package sneakers.common.api.provider;

import java.util.List;

import org.apache.solr.common.SolrDocumentList;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleProvider {

    void savePageInfo(List<PageInfo> list);

    void deleteAll();

    SolrDocumentList findByTitle(String title, Integer page, Integer size);

}
