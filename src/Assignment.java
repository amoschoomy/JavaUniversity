/**
 * Implements Assignment which is part of the assessment in the unit. A subclass of Assessment
 * class.
 *
 * @author Amos
 */
public class Assignment extends Assessment {
  private String title;

  /**
   * Creates an Assignment object.
   *
   * @param weight weight of the assignment. Inherits superclass method when setting weight.
   * @param title String title of the assignment.
   */
  Assignment(int weight, String title) {
    super(weight);
    this.title = title;
    super.setWeight(weight);
  }

  /**
   * Overrides description method in superclass.
   *
   * @return description of the Assignment.
   */
  @Override
  public String description() {
    return title + "," + getWeight() + "%";
  }
}
