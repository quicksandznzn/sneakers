package sneakers.solr.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SneakersSolrUtilityApplication {

    private static final Logger log = LoggerFactory.getLogger(SneakersSolrUtilityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SneakersSolrUtilityApplication.class, args);
        log.info(
                "====================== SNEAKERS SOLR UTILITY APPLICATION START ======================");
    }

}
