import java.util.HashSet;
import java.util.Iterator;

/**
 * Implements Unit for University.
 *
 * @author Amos
 */
public class Unit {
  private String unitCode;
  private String name;
  private HashSet<String> enrolledStudents = new HashSet<>();
  private AssessmentScheme assessmentScheme;
  private University university;
  private HashSet<Course> coreUnitInCourse=new HashSet<>();

  /**
   * Creates Unit object based on three parameters, unitCode,name,assessmentScheme.
   * @param unitCode unit code of the unit in String.
   * @param name String name of the unit.
   * @param assessmentScheme Assessment scheme of the unit. Needs an AssessmentScheme object
   */
  Unit(String unitCode, String name, AssessmentScheme assessmentScheme) {
    this.name = name;
    this.unitCode = unitCode;
    this.assessmentScheme = assessmentScheme;
  }

  /**
   * Description of the unit.
   * @return String description of the unit.
   */
  public String description() {
    return unitCode + " " + name;
  }

  /**
   * Enrols students by adding them into a HashSet.
   * @param newStudent Student object to be added
   */
  public void enrolStudent(Student newStudent) {
    enrolledStudents.add(newStudent.getStudentId());
  }

  /**
   * Get enrolled Student list in the Unit
   * @return An array of students enrolled in the unit
   */
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

  /**
   * set the Assesment scheme of the unit.
   * @param assessmentScheme Assessment Scheme object that contains a list of asssessments in the unit.
   */
  public void setAssessmentScheme(AssessmentScheme assessmentScheme) {
    this.assessmentScheme = assessmentScheme;
  }

  /**
   * set which university have the Unit.
   * @param university University object.
   */
  public void setUniversity(University university) {
    this.university = university;
  }

  /**
   * Describes the list of asssessment in the unit.
   * @return a String description of list of assessments in the unit.
   */
  public String AssessmentSchemeDescription() {
    String assessments = "";
    ;
    for (Assessment a : assessmentScheme.getAssessments()) {
      assessments += a.description() + "\n";
    }
    return assessments;
  }

  /**
   * Checks if a student is enrolled in the Unit.
   * @param studentID Student ID of the Student
   * @return boolean status of the student enrolment in the unit
   */
  public boolean isEnrolled(String studentID) {
    boolean status = false;
    for (Student student : getEnrolledStudentList()) {
      if (student.getStudentId().equals(studentID)) {
        status = true;
      }
    }
    return status;
  }

  /**
   * Checks if student has completed all assessment in the unit
   * @param studentID student ID of the student
   * @return boolean result of student completion of all asssements
   */
  public boolean completedAllAssessments(String studentID) {
    boolean status = true;
    for (Assessment a : assessmentScheme.getAssessments()) {
      if (a.getStudentMark(studentID) == null) {
        status = false;
      }
    }
    return status;
  }

  /**
   * getter for total student marks in the unit.
   * Returns 0 if student has not completed all assessments in the unit or not enrolled
   * @param studentID student ID of student
   * @return  actual total student marks of the unit if and only if the student is enrolled and completed all assessments
   */
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

  /**
   * setter for student mark of an assessment in the unit
   * @param studentID student ID of the student.
   * @param mark Mark object of the mark to be given to the student.
   * @param assessment Assessment object which can consist of Exam or Asssignment.
   */
  public void setStudentMark(String studentID, Mark mark, Assessment assessment) {
    if (assessmentScheme.getAssessments().contains(assessment) && isEnrolled(studentID)) {
      assessment.addStudentMarks(studentID, mark);
    }
  }

  /**
   * Checks if the unit is a core unit of the Course
   * @param c Course in the university
   * @return boolean status of the core unit
   */
  public boolean isCore(Course c){
    boolean status=true;
    if (coreUnitInCourse.contains(c)){
    status=false;
  }
    return status;
}

  /**
   * Add the unit as a core unit of a course
   * @param c Course in which the unit is a core
   */
  public void addToCore(Course c){
    coreUnitInCourse.add(c);
  }

  /**
   * Getter for list of course that has this unit as a core
   * @return String description of list of courses that has this unit as a core
   */
  public String getCoursesCoreUnit(){
    String list="The courses where "+name+"is a core: \n";
    for (Course c :coreUnitInCourse ) {
      list+=c.getName()+"\n";
    }
    return list;
  }

}
