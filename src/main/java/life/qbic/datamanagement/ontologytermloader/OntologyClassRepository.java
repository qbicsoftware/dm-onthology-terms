package life.qbic.datamanagement.ontologytermloader;

import life.qbic.datamanagement.ontologytermloader.model.OntologyClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
@Component
public interface OntologyClassRepository extends CrudRepository<OntologyClassEntity, Long> {

}
