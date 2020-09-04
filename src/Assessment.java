import java.util.HashMap;

public abstract class Assessment {
  private int weight;
  private HashMap<String, Mark> studentMarks = new HashMap<>();

  Assessment(int weight) {
    setWeight(weight);
  }

  public void setWeight(int weight) {
    if (weight < 1 || weight > 100) {
      throw new IllegalArgumentException(
          "Minimum weight of an assessment is 1% and maximum weight is 100%");
    }
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public abstract String description();

  public void addStudentMarks(String StudentID, Mark mark) {
    studentMarks.put(StudentID, mark);
  }

  public Mark getStudentMark(String studentID) {
    return studentMarks.get(studentID);
  }
}
