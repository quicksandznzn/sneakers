package sneakers.provider.solr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import sneakers.common.api.model.PageInfo;

@Repository
public interface SolrHandleRepository extends SolrCrudRepository<PageInfo, Integer> {
    Page<PageInfo> findByTitle(String title, Pageable pageable);
}
