package mg.bocasay.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@EnableJpaRepositories("mg.bocasay.demo.repository")
@ComponentScan("mg.bocasay.demo")
public class AppConfig {

}
