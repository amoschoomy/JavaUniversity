import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class University {

  private ArrayList<Unit> units = new ArrayList<>();
  private HashMap<String, Student> students = new HashMap<>();
  private Exam exam = new Exam(30, 180);
  private Exam exam2 = new Exam(40, 69);
  private Assignment bootcamp = new Assignment(30, "JavaBootCamp");
  private Assignment JavaKing = new Assignment(70, "Java Experts");
  private HashSet<Course> courses = new HashSet<>();

  University() {
    createUnits();
    createCourses();
  }

  public void printStatus() {
    System.out.println("Welcome to Java University");
    System.out.println();
    displayUnits();
    System.out.println("Thank you for using Java University");
  }

  public void createUnits() {
    // Test for asssesment creation
    try {
      Exam fakeExam = new Exam(-5, 45);
      Exam fakeExam1 = new Exam(40, -69);
      Exam exam = new Exam(1, 180);
      Exam fakeExam2 = new Exam(101, 30);
      Exam exam2 = new Exam(40, 69);
      Exam tooLong = new Exam(20, 1000000);
      Assignment bootcamp = new Assignment(30, "JavaBootCamp");
      Assignment fakeAsgn = new Assignment(0, "Hello");
      Assignment fake = new Assignment(1000, "Scammed");
      Exam JavaKing = new Exam(70, 120);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    // Test for Assesmment Scheme
    try {
      AssessmentScheme assessmentScheme = new AssessmentScheme();
      assessmentScheme.addAssessments(exam);
      assessmentScheme.addAssessments(exam2);
      assessmentScheme.addAssessments(bootcamp);
      assessmentScheme.addAssessments(JavaKing);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    AssessmentScheme FIT1234AS = new AssessmentScheme();
    FIT1234AS.addAssessments(exam);
    FIT1234AS.addAssessments(JavaKing);
    units.add(new Unit("FIT1234", "OOP", FIT1234AS));
    units.add(new Unit("FIT1212", "Failure", FIT1234AS));

    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 1; i++) {
      Student newStudent;
      String givenName, familyName, id;
      System.out.println("Please enter your given name: ");
      givenName = sc.nextLine();
      System.out.println("Please enter your family name: ");
      familyName = sc.nextLine();
      System.out.println("Please enter your student ID: ");
      id = sc.nextLine();

      // Test for studentID
      try {
        admitStudent(new Student(id, givenName, familyName));
        units.get(i).enrolStudent(new Student(id, givenName, familyName));
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      }
    }
    sc.close();
  }

  // Test for Mark object
  public void testMark() {
    admitStudent(new Student("31164498", "Amos", "Choo"));
    admitStudent(new Student("12345678", "Jia Shern", "Choo"));
    units.get(0).enrolStudent(students.get("31164498"));
    try {
      units.get(0).setStudentMark("31164498", new Mark(111, "Over"), JavaKing);
      units.get(0).setStudentMark("31154498", new Mark(-1, "LOL"), JavaKing);
      System.out.println(units.get(0).getTotalStudentMarks("31164498"));
      System.out.println(JavaKing.getStudentMark("31164498"));
      System.out.println(exam.getStudentMark("31164498"));
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    try {
      units.get(0).setStudentMark("31164498", new Mark(90, "Excellent work son"), exam);
      units.get(0).setStudentMark("31164498", new Mark(69, "Nice"), JavaKing);
      System.out.println(units.get(0).getTotalStudentMarks("31164498"));
      System.out.println(JavaKing.getStudentMark("31164498"));
      System.out.println(exam.getStudentMark("31164498"));

    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  public void createCourses() {
    try {
      Course CS = new Course("Bachelor of CS", 0, 1);
      Course SE = new Course("Bachelor of SE", 4, 0);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    Course ComputerScienceMaster = new Course("CS Master", 2, 1);
    Course CodingExpert = new Course("Coding Experts", 1, 1);
    courses.add(CodingExpert);
    courses.add(ComputerScienceMaster);
    CodingExpert.addUnittoCore(units.get(0));
    ComputerScienceMaster.addUnittoCore(units.get(1));
    ComputerScienceMaster.addUnittoCore(units.get(0));
    try {
      ComputerScienceMaster.addUnittoElective(units.get(1));
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
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

  public void displayGraduates() {
    System.out.println("Graduates: \n");
    for (Course c : courses) {
      System.out.println(c.getName() + "\n");
      System.out.println(c.listOfStudentsEligibleTOGraduate());
    }
  }
}
