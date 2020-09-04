public class Student {
  private String studentId;
  private String givenName;
  private String familyName;

  Student(String newStudentId) {
    if (newStudentId.length() != 8) {
      throw new IllegalArgumentException("Student ID must be of 8 digits only");
    }
    this.studentId = newStudentId;
  }

  Student(String newStudentId, String newGivenName, String newFamilyName) {
    if (newStudentId.length() != 8) {
      throw new IllegalArgumentException("Student ID must be of 8 digits only");
    }
    this.studentId = newStudentId;
    this.givenName = newGivenName;
    this.familyName = newFamilyName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getStudentId() {
    return new Student(studentId).studentId;
  }

  public String description() {
    return studentId + " " + givenName + " " + familyName;
  }
}
