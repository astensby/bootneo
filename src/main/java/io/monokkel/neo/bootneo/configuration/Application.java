package io.monokkel.neo.bootneo.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by astensby on 28/09/14.
 */
@Configuration
@EnableNeo4jRepositories("io.monokkel.neo.bootneo.repositories")
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application extends Neo4jConfiguration{

    public Application() {
        setBasePackage("io.monokkel.neo.bootneo.domain");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/hello.db");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
