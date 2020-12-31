package CourseManagement;
import java.util.*;

public class Course {
  
  private String courseName;
  private ArrayList<Assignment> assignment;
  private ArrayList<Assignment> quizzes;
  private ArrayList<String> students;
  
  public Course(String courseName) {
    assignment = new ArrayList<Assignment>();
    quizzes = new ArrayList<Assignment>();
    students = new ArrayList<String>();
    this.courseName = courseName;
  }
  
  public String getCourseName() {
    return this.courseName;
  }
  
  public void addAssignment(String title, String note) {
    this.assignment.add(new Assignment(title, note));
  }
  
  public void removeAssignment(String title) {
    this.assignment.remove(assignment.indexOf(title));
  }
  
  public void printAllAssignments() {
    for(int i = 0; i < this.assignment.size(); i++) {
      System.out.println(this.assignment.get(i));
    }
  }
  
  public void printAsssignmentNote(String title) {
    System.out.println(this.assignment.get(this.assignment.indexOf(title)).getNote());
  }
  
  public boolean findStudent(String name) {
    if(this.students.indexOf(name) != -1) return true;
    return false;
  }
  
  public void addStudent(String name) {
    boolean check = false;
    for(int i = 0; i < this.students.size(); i++) {
      if(this.students.get(i).equals(name)) {
        check = true;
        break;
      }
    }
    if(check) this.students.add(name);
  }
  
  public void removeStudent(String name) {
    this.students.remove(name);
  }
  
  
}