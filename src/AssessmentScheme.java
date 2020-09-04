import java.util.ArrayList;

public class AssessmentScheme {
  private ArrayList<Assessment> assessments = new ArrayList<>();

  public ArrayList<Assessment> getAssessments() {
    return new ArrayList<>(assessments);
  }

  public void addAssessments(Assessment assessment) {
    int totalWeight = 0;
    for (Assessment a : assessments) {
      totalWeight += a.getWeight();
    }
    if (totalWeight + assessment.getWeight() <= 100) {
      assessments.add(assessment);
    } else {
      throw new IllegalArgumentException("Assessment Weight is over 100%");
    }
  }
}
