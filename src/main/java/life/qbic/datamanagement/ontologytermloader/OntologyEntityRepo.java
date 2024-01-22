package life.qbic.datamanagement.ontologytermloader;

import life.qbic.datamanagement.ontologytermloader.model.OntologyClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
@Component
public class OntologyEntityRepo {

  private final OntologyClassRepository ontologyClassRepository;

  @Autowired
  public OntologyEntityRepo(OntologyClassRepository ontologyClassRepository) {
    this.ontologyClassRepository = ontologyClassRepository;
  }

  public void save(OntologyClassEntity classEntity) {
    ontologyClassRepository.save(classEntity);
  }
}
