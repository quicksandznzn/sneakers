package sneakers.provider.solr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SneakersProviderSolrApplicaiton {

    private static final Logger LOG =
            LoggerFactory.getLogger(SneakersProviderSolrApplicaiton.class);

    public static void main(String[] args) {

        SpringApplication.run(SneakersProviderSolrApplicaiton.class, args);

        LOG.info(
                "====================== SNEAKERS PROVIDER SOLR APPLICATION START ======================");
    }
}
