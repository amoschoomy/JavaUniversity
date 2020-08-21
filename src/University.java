import java.util.ArrayList;
import java.util.Scanner;

public class University {

  private ArrayList<Unit> units;

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
    //    Student studentA = new Student("12345678", "Victor", "Chang");
    //    Student studentB = new Student("12345679", "Fred", "Nurke");
    //    Student studentC = new Student("12345680");
    //    studentC.setFamilyName("Naidu");
    //        studentC.setGivenName("Indira");
    units.add(new Unit("FIT1234", "Advanced Bogosorts"));
    units.add(new Unit("FIT2027", "Introduction to Spaghetti Coding"));
    units.add(new Unit("FIT1234", "Enterprise Fizzbuzz"));
    units.add(new Unit("FIT2099", "Object Orientated Programming"));
    //    units.get(0).enrolStudent(studentA);
    //    units.get(0).enrolStudent(studentB);
    //    units.get(2).enrolStudent(studentC);
    //    units.get(1).enrolStudent(studentC);

    /*Commented codes is hardcoded students object
    Below codes loop 3 times and ask for user input for
    given names, family names and student id. Unit enrolled by the newly
    created object is fixed according to loop iteration number inside the arraylist
    of units. Maybe in the future, user can set which units they want to enrol*/
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
      new Student(givenName, familyName, id);
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
      System.out.println("\n");
    }
  }
}
