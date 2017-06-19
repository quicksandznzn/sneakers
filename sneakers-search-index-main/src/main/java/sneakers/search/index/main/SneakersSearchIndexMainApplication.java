package sneakers.search.index.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SneakersSearchIndexMainApplication {

    private static final Logger LOG =
            LoggerFactory.getLogger(SneakersSearchIndexMainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SneakersSearchIndexMainApplication.class, args);
        LOG.info(
                "====================== SNEAKERS SEARCH INDEX MAIN APPLICATION START ======================");
    }

}
