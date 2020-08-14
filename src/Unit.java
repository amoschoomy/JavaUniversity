public class Unit {
    String unitCode;
    String name;

    Unit(String unitCode,String name){
        this.name=name;
        this.unitCode=unitCode;
    }
    public String getUnitDescription(){
        return unitCode+" "+name;
    }
}
