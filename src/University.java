public class University {

  private Unit[] units;

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
    units = new Unit[3];
    for (int i = 0; i < 3; i++) {
      units[i] = new Unit("FIT", Integer.toString(i));
    }
  }

  public void displayUnits() {
    for (Unit u : units) {
      System.out.println(u.getUnitDescription());
    }
  }
}
