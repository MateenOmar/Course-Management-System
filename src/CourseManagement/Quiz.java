package CourseManagement;

public class Quiz {
  
  private String title;
  private String note;
  private int timeLimit;
  
  public Quiz(String title, String note, int timeLimit) {
    this.title = title;
    this.note = note;
    this.timeLimit = timeLimit;
  }
  
  public void changeTitle(String title) {
    this.title = title;
  }
  
  public void changeNote(String note) {
    this.note = note;
  }
  
  public void changeTimeLimit(int timeLimit) {
    this.timeLimit = timeLimit;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getNote() {
    return this.note;
  }
  
  public void printTitle() {
    System.out.println(this.title);
  }
  
  public void printNote() {
    System.out.println(this.note);
  }
}
