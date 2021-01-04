package CourseManagement;

import java.util.ArrayList;

public class Administrator {

  private String firstName;
  private String lastName;
  private String adminID;
  private School school;
  private int numForStudents; 
  private int numForInstructors; 

  public Administrator(String firstName, String lastName, School school) {
    this.school = school;
    this.adminID = lastName + firstName;
    numForStudents = 314;
    numForInstructors = 111;
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

  //UNSURE about this method
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
        //offeredList.get(i).addStudent(student);
        ArrayList<Course> courses = student.getEnrolledCourses();
        courses.add(offeredList.get(i));
        student.setEnrolledCourses(courses);
        return true;
      }
      
    }

    return false;
  }

  //UNSURE about this method
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
        //offeredList.get(i).addInstructor(instructor);
        ArrayList<Course> courses = instructor.getInstructorForCourses();
        courses.add(offeredList.get(i));
        instructor.setInstructorForCourses(courses);
        return true;
      }
      
    }

    return false;
  }
  
  //UNSURE
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
      
//      ArrayList<Student> courseStudentList = offeredList.get(student.getEnrolledCourses().get(i)).getStudents();
//      courseStudentList.remove(student);
//      offeredList.get(student.getEnrolledCourses().get(i)).setStudents(courseStudentList);
      
//      for(int j = 0; j < offeredList.size(); j++) {
//        if(student.getEnrolledCourses().get(i).getCourseName() == offeredList.get(j).getCourseName()) {
//          ArrayList<Student> courseStudentList = offeredList.get(j).getStudents();
//          courseStudentList.remove(student);
//        }
//      }
      
    }
    
    studentList.remove(student);
    school.setStudents(studentList);
    
    return true;
  }
  
  //UNSURE
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
//      ArrayList<Instructor> courseInstructorList = offeredList.get(instructor.getInstructorForCourses().get(i)).getInstructors();
//      courseInstructorList.remove(instructor);
//      offeredList.get(instructor.getInstructorForCourses().get(i)).setInstructors(courseInstructorList);
    }
    
    instructorList.remove(instructor);
    school.setInstructors(instructorList);
    
    return true;
  }
  
  //UNSURE
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
//        ArrayList<Student> courseStudentList = offeredList.get(i).getStudents();
//        courseStudentList.remove(student);
//        offeredList.get(i).setStudents(courseStudentList);
        
        ArrayList<Course> studentsCourses = student.getEnrolledCourses();
        studentsCourses.remove(offeredList.get(i));
        student.setEnrolledCourses(studentsCourses);
        
        return true;
      }
      
    }
    
    
    return false;
  }
  
  //UNSURE
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
//        ArrayList<Instructor> courseInstructorList = offeredList.get(i).getInstructors();
//        courseInstructorList.remove(instructor);
//        offeredList.get(i).setInstructors(courseInstructorList);
        
        ArrayList<Course> instructorsCourses = instructor.getInstructorForCourses();
        instructorsCourses.remove(offeredList.get(i));
        instructor.setInstructorForCourses(instructorsCourses);
        
        return true;
      }
      
    }
    
    return false;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public String getAdminID() {
    return this.adminID;
  }

}
