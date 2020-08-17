public class Unit {
  private String unitCode;
  private String name;

  Unit(String unitCode, String name) {
    this.name = name;
    this.unitCode = unitCode;
  }

  public String getUnitDescription() {
    return unitCode + " " + name;
  }
}
