import java.util.HashMap;

/**
 * General hierachy for Assessments in the University. Implements assessments for Units in
 * University. An abstract class with several abstract methods which must be inherited by
 * subclasses.
 *
 * @author Amos
 */
public abstract class Assessment {
  private int weight;
  private HashMap<String, Mark> studentMarks = new HashMap<>();

  /**
   * All assessment must have a weight
   *
   * @param weight an integer value from 1-100
   * @throws IllegalArgumentException if weight is not 1-100
   */
  Assessment(int weight) {
    setWeight(weight);
  }

  /**
   * Set weight of assessment if it's 1-100
   *
   * @param weight an integer value from 1-100
   * @throws IllegalArgumentException if weight is not 1-100
   */
  public void setWeight(int weight) {
    if (weight < 1 || weight > 100) {
      throw new IllegalArgumentException(
          "Minimum weight of an assessment is 1% and maximum weight is 100%");
    }
    this.weight = weight;
  }

  /**
   * Get weight of assessment
   *
   * @return weight of asssessment
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Gives the description of the assessment. An abstract method that must be implemented by
   * subclasses.
   *
   * @return String description of that assessment.
   */
  public abstract String description();

  /**
   * Add student marks into a HashSet.
   *
   * @param StudentID StudentID of that student.
   * @param mark Mark object.
   */
  public void addStudentMarks(String StudentID, Mark mark) {
    studentMarks.put(StudentID, mark);
  }

  /**
   * Get the particular student mark of that assessment.
   *
   * @param studentID StudentID of the student.
   * @return String description of Mark object.
   */
  public Mark getStudentMark(String studentID) {
    return studentMarks.get(studentID);
  }
}
