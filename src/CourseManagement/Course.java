package CourseManagement;
import java.util.*;

public class Course {
  
  private String courseName;
  private ArrayList<Assignment> assignment;
  private ArrayList<Quiz> quizzes;
  private ArrayList<Student> students;
  private ArrayList<Instructor> instructors;
  
  public Course(String courseName) {
    assignment = new ArrayList<Assignment>();
    quizzes = new ArrayList<Quiz>();
    students = new ArrayList<Student>();
    instructors = new ArrayList<Instructor>();
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
  
  public void printAllAssignmentsTitle() {
    for(int i = 0; i < this.assignment.size(); i++) {
      this.assignment.get(i).printTitle();
    }
  }
  //finds an instructor in the course
  public boolean findInstructor(int instructorID) {
    for(int i = 0; i < instructors.size(); i++) {
      if(this.instructors.get(i).getInstructorID().equals(instructorID)) return true;
    }
    return false;
  }
  //adds an instructor to the course
  public void addInstructor(String firstName, String lastName, int num) {
    
    String instructorID = lastName + firstName + num;
    boolean check = true;
    for(int i = 0; i < this.instructors.size(); i++) {
      if(this.instructors.get(i).getInstructorID().equals(instructorID)) {
        check = false;
        break;
      }
    }
    if(check) this.students.add(new Student(firstName, lastName, num));
  }
  //remove an instructor in the course
  public void removeInstructor(String instructorID) {
    for(int i = 0; i < students.size(); i++) {
      if(instructors.get(i).getInstructorID().equals(instructorID)) {
        this.instructors.remove(instructors.get(i));
        break;
      }
    }
  }
  
  public boolean findStudent(int studentID) {
    for(int i = 0; i < students.size(); i++) {
      if(this.students.get(i).getStudentID().equals(studentID)) return true;
    }
    return false;
  }
  
  public void addStudent(String firstName, String lastName, int num) {
    String studentID = lastName + firstName + num;
    boolean check = true;
    for(int i = 0; i < this.students.size(); i++) {
      if(this.students.get(i).getStudentID().equals(studentID)) {
        check = false;
        break;
      }
    }
    if(check) this.students.add(new Student(firstName, lastName, num));
  }
  
  public void removeStudent(String studentID) {
    for(int i = 0; i < students.size(); i++) {
      if(students.get(i).getStudentID().equals(studentID)) {
        this.students.remove(students.get(i));
        break;
      }
    }
  }
  
  
  
}