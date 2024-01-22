package life.qbic.datamanagement.ontologytermloader.model;

import java.util.List;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
public record Ontology(String ontologyName, String ontologyBaseIri, String ontologyTitle, String ontologyVersionInfo, List<OntologyClass> classes) {


}
