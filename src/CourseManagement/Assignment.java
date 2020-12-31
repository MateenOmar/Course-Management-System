package CourseManagement;

public class Assignment {

  private String title;
  private String note;
  
  public Assignment(String title, String note) {
    this.title = title;
    this.note = note;
  }
  
  public void changeTitle(String title) {
    this.title = title;
  }
  
  public void changeNote(String note) {
    this.note = note;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getNote() {
    return this.note;
  }
  
}