public abstract class Assessment {
  private int weight;

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public abstract String description();
}
