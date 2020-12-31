package CourseManagement;

import java.util.ArrayList;

public class Instructor {
  
  private ArrayList<Course> instructorForCourses;
  private String name;
  
  public Instructor(String name) {
    this.name = name;
    this.instructorForCourses = new ArrayList<Course>();
  }

  public ArrayList<Course> getInstructorForCourses() {
    return instructorForCourses;
  }

  public String getName() {
    return name;
  } 

}
