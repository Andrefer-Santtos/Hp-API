package write.your.magic.hp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HpApplication {

    private static final Logger log = LoggerFactory.getLogger(HpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HpApplication.class, args);
        log.info("HP-API STARTED!");
    }

}
