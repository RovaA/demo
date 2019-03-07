package mg.rova.demo.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories
public class ElasticConfig {

    @Value("${elasticsearch.host:127.0.0.1}")
    private String host;

    @Value("${elasticsearch.port:9300}")
    private int port;

    @Autowired
    private ElasticProperties elasticProperties;

    @Bean
    public Client client() throws UnknownHostException {
        final Settings settings = Settings.builder()
                .put("cluster.name", elasticProperties.getClusterName())
                .build();
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }

}
