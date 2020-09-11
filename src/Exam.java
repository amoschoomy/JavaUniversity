/**
 * Implements Exam which is a part of Assessment. Inherits Assessment class
 *
 * @author Amos
 */
public class Exam extends Assessment {
  private int duration;

  /**
   * Creates Exam object
   *
   * @param weight Sets the weight of Exam by it's superclass methods
   * @param duration Must be 30-180
   * @throws IllegalArgumentException if exam duration is <30 or more than 180
   */
  Exam(int weight, int duration) {
    super(weight);
    if (duration < 30) {
      throw new IllegalArgumentException("Exam duration is too short");
    }
    if (duration > 180) {
      throw new IllegalArgumentException("Exam duration is too long");
    }
    this.duration = duration;
    super.setWeight(weight);
  }

  /**
   * Overrides superclass method
   *
   * @return description of Exam
   */
  @Override
  public String description() {
    return "Exam: duration " + duration + "minutes, weight " + getWeight() + "%";
  }
}
