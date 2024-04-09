package life.qbic.datamanagement.ontologytermloader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import life.qbic.datamanagement.ontologytermloader.model.Ontology;
import life.qbic.datamanagement.ontologytermloader.model.OntologyClass;
import life.qbic.datamanagement.ontologytermloader.model.OntologyClassEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OntologyTermLoaderApplication {

  public static void main(String[] args)
      throws URISyntaxException, IOException, InterruptedException, ExecutionException {

    var context = SpringApplication.run(OntologyTermLoaderApplication.class, args);

    var ontologyPath = context.getBean(OntologyPath.class);

    var ontologyRepo = context.getBean(OntologyEntityRepo.class);

    var ontologyReader = new OntologyReader(Paths.get(ontologyPath.value()));

    var loadingTask = ontologyReader.load().thenApplyAsync(ontology -> {
      System.out.println("Loaded ontology: %s - %s".formatted(ontology.ontologyName().toUpperCase(),
          ontology.ontologyTitle()));
      return ontology;
    });


    while (!loadingTask.isDone()) {
      System.out.println("\rLoading ontology from file...");
      Thread.sleep(100);
    }

    var ontology = loadingTask.get();
    var entities = convert(ontology.classes(), ontology);

    entities.forEach(ontologyClassEntity -> {
      System.out.println("Saving class to repo: " + ontologyClassEntity);
      ontologyRepo.save(ontologyClassEntity);
    });

  }

  static Collection<OntologyClassEntity> convert(Collection<OntologyClass> ontologyClasses,
      Ontology ontology) {
    return ontologyClasses.stream().map(ontologyClass ->
        new OntologyClassEntity(ontology.ontologyName(), ontology.ontologyVersionInfo(),
            ontology.ontologyBaseIri(), ontologyClass.getLabel(), ontologyClass.getName(),
            ontologyClass.getDescription(), ontologyClass.getIri())
    ).collect(Collectors.toList());
  }
}
