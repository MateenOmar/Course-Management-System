package CourseManagement;

import java.util.ArrayList;

public class Instructor {
  
  private ArrayList<Course> instructorForCourses;
  private String firstName;
  private String lastName;
  private String instructorID;
  private String idPassword;
  
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
  
  public String getIdPassword() {
    return idPassword;
  }
  
  public void setInstructorForCourses(ArrayList<Course> instructorForCourses) {
    this.instructorForCourses = instructorForCourses;
  }
  
  public void setIdPassword(String idPassword) {
    this.idPassword = idPassword;
  }

  public String getInstructorID() {
    return this.instructorID;
  }

}
