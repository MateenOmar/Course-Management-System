package CourseManagement;

import java.util.ArrayList;

public class Student {
  
  private ArrayList<Course> enrolledCourses;
  private ArrayList<ArrayList<Float>> grades;
  private String firstName;
  private String lastName;
  private String studentID;
  
  public Student(String firstName, String lastName, int num) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentID = lastName + firstName + num;
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
  
  public ArrayList<ArrayList<Float>> getGrades(){
    return this.grades;
  }
  
  public void setGrades(ArrayList<ArrayList<Float>> grades){
    this.grades = grades;
  }
  
  public int getCourseIndex(String courseName) {
    for(int i = 0; i < enrolledCourses.size(); i++) {
      if(enrolledCourses.get(i).getCourseName().equals(courseName)) {
        return i;
      }
    }
    return -1;
  }
  
}
