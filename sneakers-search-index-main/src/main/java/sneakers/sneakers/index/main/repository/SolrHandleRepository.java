package sneakers.sneakers.index.main.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleRepository extends SolrCrudRepository<PageInfo, Integer> {

    Page<PageInfo> findByTitle(String title, Pageable pageable);
}
