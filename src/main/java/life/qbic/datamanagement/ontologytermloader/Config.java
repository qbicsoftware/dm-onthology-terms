package life.qbic.datamanagement.ontologytermloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
@Configuration
@PropertySource("application.properties")
public class Config {

  @Bean
  public OntologyPath ontologyPath(@Value("${path.to.ontology}") String ontologyPath) {
    return new OntologyPath(ontologyPath);
  }

}
