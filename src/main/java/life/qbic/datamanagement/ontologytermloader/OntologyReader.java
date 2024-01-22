package life.qbic.datamanagement.ontologytermloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import life.qbic.datamanagement.ontologytermloader.model.Ontology;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
public class OntologyReader {

  private final Path ontologyPath;

  public OntologyReader(Path ontologyPath) {
    this.ontologyPath = Objects.requireNonNull(ontologyPath);
  }

  public CompletableFuture<Ontology> load() throws IOException {
    var objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    return CompletableFuture.supplyAsync(() -> {
      try {
        return objectMapper.readValue(new File(ontologyPath.toUri()), Ontology.class);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

}
