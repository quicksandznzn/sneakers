package sneakers.sneakers.index.main.service.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleService {

    Page<PageInfo> findByTitle(String title, Pageable pageable);

}
