package sneakers.provider.solr.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import sneakers.common.api.model.PageInfo;
import sneakers.provider.solr.repository.SolrHandleRepository;
import sneakers.provider.solr.service.SolrHandleService;

@Service
public class SolrHandleServiceImpl implements SolrHandleService {

    private static final Logger LOG = LoggerFactory.getLogger(SolrHandleServiceImpl.class);
    @Autowired
    private SolrHandleRepository solrHandleRepository;

    @Autowired
    private SolrClient solrClient;

    @Value("${sneakers_collection}")
    private String SNEAKERS_COLLECTION;

    @Override
    public void savePageInfo(List<PageInfo> list) {
        solrHandleRepository.save(list);

    }

    @Override
    public void deleteAll() {
        solrHandleRepository.deleteAll();

    }

    @Override
    public SolrDocumentList findByTitle(String title, Integer page, Integer size) {
        SolrDocumentList sdl = null;
        try {
            QueryResponse qr =
                    solrClient.query(SNEAKERS_COLLECTION, createSolrParams(title, page, size));
            if (qr == null) {
                return null;
            }
            sdl = qr.getResults();
        } catch (SolrServerException | IOException e) {
            LOG.error("FINDBYTITLE ERROR", e);
            return null;
        }
        return sdl;
    }

    /**
     * createSolrParams
     * 
     * @param title
     * @param page
     * @param size
     * @return
     */
    private SolrParams createSolrParams(String title, Integer page, Integer size) {
        SolrQuery sq = new SolrQuery();
        StringBuffer sb = new StringBuffer();

        if (!Strings.isNullOrEmpty(title)) {
            sb.append("title:" + title);
        }
        String queryStr = sb.toString();
        if (Strings.isNullOrEmpty(queryStr)) {
            queryStr = "*:*";
        }
        sq.setQuery(queryStr);

        sq.add("sort", "score desc,releaseDate desc");

        int start = (page - 1) * size;
        sq.add("start", String.valueOf(start));
        sq.add("rows", String.valueOf(size));

        return sq;
    }


}
