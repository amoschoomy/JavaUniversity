public class University {

  Unit[] unit;

  University() {
    createUnits();
  }

  public void printStatus() {
    System.out.println("Welcome to Java University");
    System.out.println();
    displayUnits();
    System.out.println("Thank you for using Java University");
    //        Unit units=new Unit("FIT1234","Advanced Bogosorts");
    //        System.out.println(units.getUnitDescription());
  }

  public void createUnits() {
    unit = new Unit[3];
    for (int i = 0; i < 3; i++) {
      unit[i] = new Unit("FIT", Integer.toString(i));
    }
  }

  public void displayUnits() {
    for (Unit u : unit) {
      System.out.println(u.getUnitDescription());
    }
  }
}
