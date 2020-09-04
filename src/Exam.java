public class Exam extends Assessment {
  private int duration;

  Exam(int weight, int duration) {
    super(weight);
    if (duration < 30) {
      throw new IllegalArgumentException("Exam duration is too short");
    }
    if (duration > 180) {
      throw new IllegalArgumentException("Exam duration is too long");
    }
    this.duration = duration;
    super.setWeight(weight);
  }

  @Override
  public String description() {
    return "Exam: duration " + duration + "minutes, weight " + getWeight() + "%";
  }
}
