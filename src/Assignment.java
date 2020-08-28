public class Assignment extends Assessment {
  private String title;

  Assignment(int weight, String title) {
    this.title = title;
    super.setWeight(weight);
  }

  @Override
  public String description() {
    return title + "," + getWeight() + "%";
  }
}
