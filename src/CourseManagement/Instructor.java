package CourseManagement;

import java.util.ArrayList;

public class Instructor {
  
  private ArrayList<Course> instructorForCourses;
  private String firstName;
  private String lastName;
  private String instructorID;
  
  public Instructor(String firstName, String lastName, int num) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.instructorID = lastName + firstName + num;
    this.instructorForCourses = new ArrayList<Course>();
  }

  public ArrayList<Course> getInstructorForCourses() {
    return this.instructorForCourses;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  } 
  
  public String getInstructorID() {
    return this.instructorID;
  }

}
