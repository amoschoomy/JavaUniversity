public class Mark {
  private double totalMarks;
  private String comments;

  Mark(double totalMarks, String comments) {
    if (totalMarks < 0 || totalMarks > 100) {
      throw new IllegalArgumentException("Total marks must be within 0-100");
    } else {
      this.comments = comments;
      this.totalMarks = totalMarks;
    }
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getComments() {
    return comments;
  }

  public void setTotalMarks(double totalMarks) {
    if (totalMarks < 0 || totalMarks > 100) {
      throw new IllegalArgumentException("Total marks must be within 1-100");
    }
    this.totalMarks = totalMarks;
  }

  public double getTotalMarks() {
    return totalMarks;
  }

  @Override
  public String toString() {
    return "Mark{" + "totalMarks=" + totalMarks + ", comments='" + comments + '\'' + '}';
  }
}
