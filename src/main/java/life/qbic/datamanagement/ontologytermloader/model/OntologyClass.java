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

  private static final int MAX_LABEL_LENGTH = 255;
  private static final int MAX_DESCRIPTION_LENGTH = 2000;

  String label;
  @JsonProperty("name")
  String name;
  String iri;

  String description;

  public OntologyClass() {
  }

  /**
   * Some Ontologies tend to swamp properties like label or description with text.
   * <p>
   * This object restricts the label to a max length of 255 and the description to a max length of
   * 2000 characters..
   *
   * @param label
   * @param name
   * @param iri
   * @param description
   * @since
   */
  public OntologyClass(String label, String name, String iri, String description) {
    setLabel(label);
    this.name = name;
    this.iri = iri;
    setDescription(description);
    ;
  }

  private static String trim(String text, int maxLength) {
    return text.length() > maxLength ? text.substring(0, maxLength) : text;
  }

  @JsonProperty("label")
  public void setLabel(String label) {
    if (label == null) {
      label = "";
    }
    this.label = trim(label, MAX_LABEL_LENGTH);
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    if (description == null) {
      description = "";
    }
    this.description = trim(description, MAX_DESCRIPTION_LENGTH);
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
