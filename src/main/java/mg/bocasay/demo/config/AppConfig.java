package mg.bocasay.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@EnableJpaRepositories("mg.bocasay.demo.repository")
@EnableAspectJAutoProxy
@ComponentScan("mg.bocasay.demo")
@Import({ SecurityConfig.class })
public class AppConfig {

}
