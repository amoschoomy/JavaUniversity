public class UniversityDriver {
  public static void main(String[] args) {
    University Monash = new University();
    for (Unit u : Monash.getUnits()) {
      u.setUniversity(Monash);
    }
    Monash.printStatus();
    Monash.testMark();
  }
}
