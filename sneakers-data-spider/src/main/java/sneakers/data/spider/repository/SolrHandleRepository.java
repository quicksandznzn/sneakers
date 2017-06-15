package sneakers.data.spider.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import sneakers.common.api.model.PageInfo;

public interface SolrHandleRepository extends SolrCrudRepository<PageInfo, Integer> {

}
