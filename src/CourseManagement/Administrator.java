package CourseManagement;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Administrator implements Serializable{

  private String firstName;
  private String lastName;
  private String adminID;
  private School school;
  private int numForStudents; 
  private int numForInstructors; 
  private String idPassword;

  public Administrator(String firstName, String lastName, School school) {
    this.school = school;
    this.firstName = firstName;
    this.lastName = lastName;
    this.adminID = lastName + firstName;
    this.idPassword = this.adminID + firstName;
    numForStudents = 5555;
    numForInstructors = 1111;
  }

  public void addStudent(String firstName, String lastName) {
    ArrayList<Student> students = school.getStudents();
    students.add(new Student(firstName, lastName, numForStudents));
    school.setStudents(students);
    numForStudents++;

  }

  public void addInstructor(String firstName, String lastName) {
    ArrayList<Instructor> instructors = school.getInstructors();
    instructors.add(new Instructor(firstName, lastName, numForInstructors));
    school.setInstructors(instructors);
    numForInstructors++;
  }

  public boolean addStudentToCourse(String studentID, String courseName) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Student> studentList = school.getStudents();
    Student student = null;
    
    for(int i = 0; i < studentList.size(); i++) {
      
      if(studentList.get(i).getStudentID().equals(studentID)) {
        student = studentList.get(i);
        break;
      }
      
    }
    
    if(student == null) {
      return false;
    }

    for(int i = 0; i < offeredList.size(); i++) {
      
      if(offeredList.get(i).getCourseName().equals(courseName)) {
        ArrayList<Student> courseStudentList = offeredList.get(i).getStudentList();
        courseStudentList.add(student);
        offeredList.get(i).setStudentList(courseStudentList);
        
        
        ArrayList<Course> courses = student.getEnrolledCourses();
        courses.add(offeredList.get(i));
        student.setEnrolledCourses(courses);
        
        return true;
      }
      
    }

    return false;
  }

  public boolean addInstructorToCourse(String instructorID, String courseName) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Instructor> instructorList = school.getInstructors();
    Instructor instructor = null;
    
    for(int i = 0; i < instructorList.size(); i++) {
      
      if(instructorList.get(i).getInstructorID().equals(instructorID)) {
        instructor = instructorList.get(i);
        break;
      }
      
    }
    
    if(instructor == null) {
      return false;
    }
    
    for(int i = 0; i < offeredList.size(); i++) {
      
      if(offeredList.get(i).getCourseName().equals(courseName)) {
        ArrayList<Instructor> courseInstructorList = offeredList.get(i).getInstructorList();
        courseInstructorList.add(instructor);
        offeredList.get(i).setInstructorList(courseInstructorList);
        
        ArrayList<Course> courses = instructor.getInstructorForCourses();
        courses.add(offeredList.get(i));
        instructor.setInstructorForCourses(courses);
        
        return true;
      }
      
    }

    return false;
  }
  
  public boolean removeStudent(String studentID) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Student> studentList = school.getStudents();
    Student student = null;
    
    for(int i = 0; i < studentList.size(); i++) {
      
      if(studentList.get(i).getStudentID().equals(studentID)) {
        student = studentList.get(i);
        break;
      }
      
    }
    
    if(student == null) {
      return false;
    } 
    
    for(int i = 0; i < student.getEnrolledCourses().size(); i++) {
      
//      ArrayList<Student> courseStudentList = offeredListget(student.getEnrolledCourses().get(i)).getStudents();
//      courseStudentList.remove(student);
//      offeredList.get(student.getEnrolledCourses().get(i)).setStudentList(courseStudentList);
      
      for(int j = 0; j < offeredList.size(); j++) {
        
        if(student.getEnrolledCourses().get(i).getCourseName() == offeredList.get(j).getCourseName()) {
          ArrayList<Student> courseStudentList = offeredList.get(j).getStudentList();
          courseStudentList.remove(student);
          offeredList.get(j).setStudentList(courseStudentList);
        }
        
      }
      
    }
    
    studentList.remove(student);
    school.setStudents(studentList);
    
    return true;
  }
  
  public boolean removeInstructor(String instructorID) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Instructor> instructorList = school.getInstructors();
    Instructor instructor = null;
    
    for(int i = 0; i < instructorList.size(); i++) {
      
      if(instructorList.get(i).getInstructorID().equals(instructorID)) {
        instructor = instructorList.get(i);
        break;
      }
      
    }
    
    if(instructor == null) {
      return false;
    }
    
    for(int i = 0; i < instructor.getInstructorForCourses().size(); i++) {
//      ArrayList<Instructor> courseInstructorList = offeredList.get(instructor.getInstructorForCourses().get(i)).getInstructorList();
//      courseInstructorList.remove(instructor);
//      offeredList.get(instructor.getInstructorForCourses().get(i)).setInstructorList(courseInstructorList);
      
      for(int j = 0; j < offeredList.size(); j++) {
        
        if(instructor.getInstructorForCourses().get(i).getCourseName() == offeredList.get(j).getCourseName()) {
          ArrayList<Instructor> courseInstructorList = offeredList.get(j).getInstructorList();
          courseInstructorList.remove(instructor);
          offeredList.get(j).setInstructorList(courseInstructorList);
        }
        
      }
      
    }
    
    instructorList.remove(instructor);
    school.setInstructors(instructorList);
    
    return true;
  }
  
  public boolean removeStudentFromCourse(String studentID, String courseName) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Student> studentList = school.getStudents();
    Student student = null;
    
    for(int i = 0; i < studentList.size(); i++) {
      
      if(studentList.get(i).getStudentID().equals(studentID)) {
        student = studentList.get(i);
        break;
      }
      
    }
    
    if(student == null) {
      return false;
    }
    
    for(int i = 0; i < offeredList.size(); i++) {
      
      if(offeredList.get(i).getCourseName().equals(courseName)) {
        ArrayList<Student> courseStudentList = offeredList.get(i).getStudentList();
        courseStudentList.remove(student);
        offeredList.get(i).setStudentList(courseStudentList);
        
        ArrayList<Course> studentsCourses = student.getEnrolledCourses();
        studentsCourses.remove(offeredList.get(i));
        student.setEnrolledCourses(studentsCourses);
        
        return true;
      }
      
    }
    
    
    return false;
  }
  
  public boolean removeInstructorFromCourse(String instructorID, String courseName) {
    ArrayList<Course> offeredList = school.getOfferedCourses();
    ArrayList<Instructor> instructorList = school.getInstructors();
    Instructor instructor = null;
    
    for(int i = 0; i < instructorList.size(); i++) {
      
      if(instructorList.get(i).getInstructorID().equals(instructorID)) {
        instructor = instructorList.get(i);
        break;
      }
      
    }
    
    if(instructor == null) {
      return false;
    }
    
    for(int i = 0; i < offeredList.size(); i++) {
      
      if(offeredList.get(i).getCourseName().equals(courseName)) {
        ArrayList<Instructor> courseInstructorList = offeredList.get(i).getInstructorList();
        courseInstructorList.remove(instructor);
        offeredList.get(i).setInstructorList(courseInstructorList);
        
        ArrayList<Course> instructorsCourses = instructor.getInstructorForCourses();
        instructorsCourses.remove(offeredList.get(i));
        instructor.setInstructorForCourses(instructorsCourses);
        
        return true;
      }
      
    }
    
    return false;
  }
  
  public void setIdPassword(String idPassword) {
    this.idPassword = idPassword;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public String getAdminID() {
    return this.adminID;
  }
  
  public String getIdPassword() {
    return idPassword;
  }

}
