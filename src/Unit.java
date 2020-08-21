import java.util.ArrayList;

public class Unit {
  private String unitCode;
  private String name;
  private ArrayList<Student> students = new ArrayList<>();

  Unit(String unitCode, String name) {
    this.name = name;
    this.unitCode = unitCode;
  }

  public String description() {
    return unitCode + " " + name;
  }

  public void enrolStudent(Student newStudent) {
    students.add(newStudent);
  }

  public ArrayList<Student> getEnrolledStudentList() {

    return new ArrayList<Student>(students);
  }
}
