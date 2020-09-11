/**
 * Implements Mark for Assessment marking
 *
 * @author Amos
 */
public class Mark {
  private double totalMarks;
  private String comments;

  /**
   * Creates Mark object that requires two parameters, totalMarks,comments.
   *
   * @param totalMarks totalMarks value in double.
   * @param comments comments in String.
   * @throws IllegalArgumentException if Total marks is not within 0-100.
   */
  Mark(double totalMarks, String comments) {
    if (totalMarks < 0 || totalMarks > 100) {
      throw new IllegalArgumentException("Total marks must be within 0-100");
    } else {
      this.comments = comments;
      this.totalMarks = totalMarks;
    }
  }

  /**
   * Setter for comments. set the comments of the object.
   *
   * @param comments comments in String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  /**
   * Getter for comments
   *
   * @return comments in String
   */
  public String getComments() {
    return comments;
  }

  /**
   * Setter for total marks of the object
   *
   * @param totalMarks a double value
   * @throws IllegalArgumentException if totalMarks given is not within 1-100
   */
  public void setTotalMarks(double totalMarks) {
    if (totalMarks < 0 || totalMarks > 100) {
      throw new IllegalArgumentException("Total marks must be within 1-100");
    }
    this.totalMarks = totalMarks;
  }

  /**
   * Getter for total marks
   *
   * @return total marks in double
   */
  public double getTotalMarks() {
    return totalMarks;
  }

  /**
   * Overrides the toString method. Description of Mark object in String
   *
   * @return String representation of Mark object
   */
  @Override
  public String toString() {
    return "Mark{" + "totalMarks=" + totalMarks + ", comments='" + comments + '\'' + '}';
  }
}
