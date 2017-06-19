package sneakers.provider.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * 
 * @author quicksandzn@gmail.com
 *
 *         init cloudsolr
 */
@Configuration
// @EnableSolrRepositories(basePackages = {"sneakers.data.spider"}, multicoreSupport = true)
public class CloudSolrConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudSolrConfig.class);

    @Value("${solr.zkHost}")
    private String zkHost;

    @Value("${solr.zkHost.clientTimeout}")
    private int clientTimeout;

    @Value("${solr.zkHost.connectTimeout}")
    private int connectTimeout;

    @Bean
    public SolrClient solrClient() {
        try {
            CloudSolrClient cloudSolrClient = new CloudSolrClient(zkHost);
            cloudSolrClient.setZkClientTimeout(clientTimeout);
            cloudSolrClient.setZkConnectTimeout(connectTimeout);
            return cloudSolrClient;
        } catch (Exception e) {
            LOGGER.error("SOLRCLOUD INIT ERROR", e);
            return null;
        }

    }

    @Bean
    public SolrTemplate solrTemplate() throws Exception {
        return new SolrTemplate(solrClient());
    }
}
