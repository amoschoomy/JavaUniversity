import java.util.HashSet;
import java.util.Iterator;

public class Unit {
  private String unitCode;
  private String name;
  private HashSet<String> enrolledStudents = new HashSet<>();
  private AssessmentScheme assessmentScheme;
  private University university;

  Unit(String unitCode, String name, AssessmentScheme assessmentScheme) {
    this.name = name;
    this.unitCode = unitCode;
    this.assessmentScheme = assessmentScheme;
  }

  public String description() {
    return unitCode + " " + name;
  }

  public void enrolStudent(Student newStudent) {
    enrolledStudents.add(newStudent.getStudentId());
  }

  public Student[] getEnrolledStudentList() {
    Student[] studentList = new Student[enrolledStudents.size()];
    int i = 0;
    for (Iterator<String> iterator = enrolledStudents.iterator(); iterator.hasNext(); ) {
      String id = iterator.next();
      if (university.getStudents().containsKey(id)) {
        studentList[i] = university.getStudents().get(id);
        i += 1;
      }
    }
    return studentList;
  }

  public void setAssessmentScheme(AssessmentScheme assessmentScheme) {
    this.assessmentScheme = assessmentScheme;
  }

  public void setUniversity(University university) {
    this.university = university;
  }

  public String AssessmentSchemeDescription() {
    String assessments = "";
    ;
    for (Assessment a : assessmentScheme.getAssessments()) {
      assessments += a.description() + "\n";
    }
    return assessments;
  }

  public boolean isEnrolled(String studentID) {
    boolean status = false;
    for (Student student : getEnrolledStudentList()) {
      if (student.getStudentId().equals(studentID)) {
        status = true;
      }
    }
    return status;
  }

  public boolean completedAllAssessments(String studentID) {
    boolean status = true;
    for (Assessment a : assessmentScheme.getAssessments()) {
      if (a.getStudentMark(studentID) == null) {
        status = false;
      }
    }
    return status;
  }

  public double getTotalStudentMarks(String studentID) {
    double totalMarks = 0;
    if (completedAllAssessments(studentID) && isEnrolled(studentID)) {
      for (Assessment a : assessmentScheme.getAssessments()) {
        //        System.out.println(a.getWeight());
        totalMarks += a.getStudentMark(studentID).getTotalMarks() * (a.getWeight());
      }
    }
    return totalMarks / 100;
  }

  public void setStudentMark(String studentID, Mark mark, Assessment assessment) {
    if (assessmentScheme.getAssessments().contains(assessment) && isEnrolled(studentID)) {
      assessment.addStudentMarks(studentID, mark);
    }
  }
}
