package sneakers.data.spider.service.solr;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleService {

    void savePageInfo(List<PageInfo> list);

    Page<PageInfo> findByTitle(String title, Pageable pageable);

    void deleteAll();
}
