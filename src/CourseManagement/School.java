package CourseManagement;

import java.util.ArrayList;

public class School {
  
  private ArrayList<Student> students;
  private ArrayList<Instructor> instructors;
  private ArrayList<Administrator> admins;
  private ArrayList<Course> offeredCourses;
  private School school = null;
  private String schoolName;
  
  
  private School(String schoolName) {
    this.schoolName = schoolName;
    students = new ArrayList<Student>();
    instructors = new ArrayList<Instructor>();
    admins = new ArrayList<Administrator>();
    offeredCourses = new ArrayList<Course>();
  }
  
  public School createInstanceOfSchool(String schoolName) {
    
    if(school == null) {
      school = new School(schoolName);
    }
    
    return school;
  }
  
  public void addStudent(String name) {
    students.add(new Student(name));
  }
  
  public void addInstructor(String name) {
    instructors.add(new Instructor(name));
  }
  
  public void addAdministrator(String name) {
    admins.add(new Administrator(name));
  }

  public String getSchoolName() {
    return schoolName;
  }

}
