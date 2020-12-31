package CourseManagement;

import java.util.ArrayList;

public class Administrator {
  
  private ArrayList<Course> enrolledCourses;
  private String name;
  
  public Administrator(String name) {
    this.name = name;
    this.enrolledCourses = new ArrayList<Course>();
  }

  public ArrayList<Course> getEnrolledCourses() {
    return this.enrolledCourses;
  }

  public String getName() {
    return name;
  }

}
