public class Exam extends Assessment {
  private int duration;

  Exam(int weight, int duration) {
    this.duration = duration;
    super.setWeight(weight);
  }

  @Override
  public String description() {
    return "Exam: duration " + duration + "minutes, weight " + getWeight() + "%";
  }
}
