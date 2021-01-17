package CourseManagement;

import java.util.ArrayList;

public class School {
  
  private ArrayList<Student> students;
  private ArrayList<Instructor> instructors;
  private ArrayList<Administrator> admins;
  private ArrayList<Course> offeredCourses;
  private static School school = null;
  private String schoolName;
  private String idPassword;
  
  private School(String schoolName) {
    this.schoolName = schoolName;
    students = new ArrayList<Student>();
    instructors = new ArrayList<Instructor>();
    admins = new ArrayList<Administrator>();
    offeredCourses = new ArrayList<Course>();
    this.idPassword = schoolName;
  }
  
  public static School createInstanceOfSchool(String schoolName) {
    
    if(school == null) {
      school = new School(schoolName);
    }
    
    return school;
  }
  
  public void addAdministrator(String firstName, String lastName) {
    this.admins.add(new Administrator(firstName, lastName, school));
  }
  
  public void addCourse(String name) {
    this.offeredCourses.add(new Course(name));
  }

  public String getSchoolName() {
    return this.schoolName;
  }

  public ArrayList<Student> getStudents() {
    return this.students;
  }
  
  public ArrayList<Instructor> getInstructors() {
    return this.instructors;
  }

  public ArrayList<Administrator> getAdmins() {
    return this.admins;
  }

  public ArrayList<Course> getOfferedCourses() {
    return this.offeredCourses;
  }
  
  public String getIdPassword() {
    return idPassword;
  }
  
  public void setStudents(ArrayList<Student> students) {
    this.students = students;
  }

  public void setInstructors(ArrayList<Instructor> instructors) {
    this.instructors = instructors;
  }
  
  public void setIdPassword(String idPassword) {
    this.idPassword = idPassword;
  }
}
