package CourseManagement;

import java.util.ArrayList;

public class School {
  
  private ArrayList<Student> students;
  private ArrayList<Instructor> instructors;
  private ArrayList<Administrator> admins;
  private ArrayList<Course> offeredCourses;
  private School school = null;
  private String schoolName;
  private int numForStudents; 
  private int numForInstructors; 
  
  
  private School(String schoolName) {
    this.schoolName = schoolName;
    numForStudents = 314;
    numForStudents = 111;
    students = new ArrayList<Student>();
    instructors = new ArrayList<Instructor>();
    admins = new ArrayList<Administrator>();
    offeredCourses = new ArrayList<Course>();
  }
  
  public School createInstanceOfSchool(String schoolName) {
    
    if(this.school == null) {
      this.school = new School(schoolName);
    }
    
    return this.school;
  }
  
  public void addStudent(String firstName, String lastName) {
    this.students.add(new Student(firstName, lastName, numForStudents));
  }
  
  public void addInstructor(String firstName, String lastName) {
    this.instructors.add(new Instructor(firstName, lastName, numForInstructors));
  }
  
  public void addAdministrator(String name) {
    this.admins.add(new Administrator(name));
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

}
