import java.util.HashSet;

public class Course {
  private String name;
  private HashSet<Unit> coreUnits = new HashSet<>();
  private HashSet<Unit> electiveUnits = new HashSet<>();
  private HashSet<Student> enrollledStudents = new HashSet<>();
  private HashSet<Student> eligibleStudents = new HashSet<>();
  private int noOfRequiredCoreUnits;
  private int noOfRequiredElectiveUnits;

  Course(String name, int noOfRequiredCoreUnits, int noOfRequiredElectiveUnits) {
    if (noOfRequiredCoreUnits < 1) {
      throw new IllegalArgumentException("Each course must have minimum one core unit");
    }
    this.name = name;
    this.noOfRequiredCoreUnits = noOfRequiredCoreUnits;
    this.noOfRequiredElectiveUnits = noOfRequiredElectiveUnits;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addEnrollledStudents(Student student) {
    enrollledStudents.add(student);
  }

  public HashSet<Student> getEnrollledStudents() {
    return new HashSet<>(enrollledStudents);
  }

  public void addUnittoCore(Unit unit) {
    coreUnits.add(unit);
  }

  public void addUnittoElective(Unit unit) {
    if (coreUnits.contains(unit)) {
      throw new IllegalArgumentException("Elective is already a core unit");
    }
  }

  public boolean eligbletoGraduate(Student student) {
    boolean eligble = true;
    int numOfElectives = 0;
    for (Unit u : coreUnits) {
      if (u.completedAllAssessments(student.getStudentId())
          && u.getTotalStudentMarks(student.getStudentId()) < 50) {
        eligble = false;
      }
    }
    if (eligble) {
      for (Unit u : electiveUnits) {
        if (u.completedAllAssessments(student.getStudentId())
            && u.getTotalStudentMarks(student.getStudentId()) >= 50) {
          numOfElectives += 1;
        }
      }
    }
    if (numOfElectives < noOfRequiredElectiveUnits) {
      eligble = false;
    }
    return eligble;
  }

  public void addEligbleStudentsToGraduate(Student student) {
    if (eligbletoGraduate(student)) {
      eligibleStudents.add(student);
    } else {
      throw new IllegalArgumentException("Student not eligible to graduate");
    }
  }

  public String listOfStudentsEligibleTOGraduate() {
    String description = "The list of eligible students to graduate in this " + name + " are: \n";
    for (Student s : eligibleStudents) {
      description += s.description() + "\n";
    }
    return description;
  }
}
