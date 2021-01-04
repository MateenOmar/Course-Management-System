package CourseManagement;

import java.util.ArrayList;

public class Student {
  
  private ArrayList<Course> enrolledCourses;
  private String firstName;
  private String lastName;
  private String studentID;
  
  public Student(String firstName, String lastName, int num) {
    this.firstName = firstName;
    this.lastName = lastName;
    studentID = lastName + firstName + num;
    this.enrolledCourses = new ArrayList<Course>();
  }

  public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
    this.enrolledCourses = enrolledCourses;
  }

  public ArrayList<Course> getEnrolledCourses() {
    return this.enrolledCourses;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  
  public String getStudentID() {
    return this.studentID;
  }
  
}
