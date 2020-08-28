import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class University {

  private ArrayList<Unit> units;
  private HashMap<String, Student> students = new HashMap<>();

  University() {
    createUnits();
  }

  public void printStatus() {
    System.out.println("Welcome to Java University");
    System.out.println();
    displayUnits();
    System.out.println("Thank you for using Java University");
  }

  public void createUnits() {
    units = new ArrayList<>();
    Exam exam = new Exam(40, 190);
    AssessmentScheme assessmentScheme = new AssessmentScheme();
    assessmentScheme.getAssessments().add(exam);
    for (int i = 0; i < 3; i++) {
      assessmentScheme.getAssessments().add(new Assignment(i + 7, "Assignment " + i));
    }
    units.add(new Unit("FIT1234", "Advanced Bogosorts", assessmentScheme));
    units.add(new Unit("FIT2027", "Introduction to Spaghetti Coding", assessmentScheme));
    units.add(new Unit("FIT1234", "Enterprise Fizzbuzz", assessmentScheme));

    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      Student newStudent;
      String givenName, familyName, id;
      System.out.println("Please enter your given name: ");
      givenName = sc.nextLine();
      System.out.println("Please enter your family name: ");
      familyName = sc.nextLine();
      System.out.println("Please enter your student ID: ");
      id = sc.nextLine();
      admitStudent(new Student(givenName, familyName, id));
      units.get(i).enrolStudent(new Student(givenName, familyName, id));
    }
    sc.close();
  }

  public void displayUnits() {
    for (Unit u : units) {
      System.out.println(u.description() + "\n" + "Enrolled Students:");
      for (Student student : u.getEnrolledStudentList()) {
        System.out.println(student.description());
      }
      System.out.println("Assessments in the unit: " + u.AssessmentSchemeDescription());
      System.out.println("\n");
    }
  }

  public void admitStudent(Student student) {
    students.put(student.getStudentId(), student);
  }

  public HashMap<String, Student> getStudents() {
    return new HashMap<>(students);
  }

  public ArrayList<Unit> getUnits() {
    return new ArrayList<>(units);
  }
}
