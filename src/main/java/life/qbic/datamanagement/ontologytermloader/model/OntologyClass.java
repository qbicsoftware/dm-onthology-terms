package life.qbic.datamanagement.ontologytermloader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <b><class short description - 1 Line!></b>
 *
 * <p><More detailed description - When to use, what it solves, etc.></p>
 *
 * @since <version tag>
 */
public class OntologyClass {

  @JsonProperty("label")
  String label;

  @JsonProperty("name")
  String name;

  String iri;

  @JsonProperty("description")
  String description;

  public OntologyClass() {
  }

  public OntologyClass(String label, String name, String iri, String description) {
    this.label = label;
    this.name = name;
    this.iri = iri;
    this.description = description;
  }

  @JsonProperty("IRI")
  public void setIRI(String iri) {
    this.iri = iri;
  }

  public String getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  public String getIri() {
    return iri;
  }

  public String getDescription() {
    return description;
  }
}
