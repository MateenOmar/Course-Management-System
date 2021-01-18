package CourseManagement;
import java.util.*;

public class Course {
  
  private String courseName;
  private ArrayList<Assignment> assignment;
  private ArrayList<Quiz> quizzes;
  private ArrayList<Student> students;
  private ArrayList<Instructor> instructors;
  private ArrayList<String> orderOfAssessments;
  
  public Course(String courseName) {
    assignment = new ArrayList<Assignment>();
    quizzes = new ArrayList<Quiz>();
    students = new ArrayList<Student>();
    instructors = new ArrayList<Instructor>();
    this.courseName = courseName;
  }
  
  public String getCourseName() {
    return this.courseName;
  }
  
  public void addAssignment(String title, String note) {
    this.assignment.add(new Assignment(title, note));
    storeOrderOfAssessments(title);
    
  }
  
  public void removeAssignment(String title) {
    for(int i = 0; i < assignment.size(); i++) {
      if(this.assignment.get(i).getTitle().equals(title)) {
        assignment.remove(i);
      }
    }
    for(int i = 0; i < students.size(); i++) {
      ArrayList<ArrayList<Float>> tempGrades = students.get(i).getGrades();
      int indexOfCourse = students.get(i).getCourseIndex(courseName);
      tempGrades.get(indexOfCourse).set(orderOfAssessments.indexOf(title), null);
    }
  }
  
  public void printAllAssignmentsTitle() {
    for(int i = 0; i < this.assignment.size(); i++) {
      this.assignment.get(i).printTitle();
    }
  }
  
  public void addQuiz(String title, String note, int timeLimit) {
    this.quizzes.add(new Quiz(title, note, timeLimit));
    storeOrderOfAssessments(title);
  }
  
  public void removeQuiz(String title) {
    for(int i = 0; i < quizzes.size(); i++) {
      if(this.quizzes.get(i).getTitle().equals(title)) {
        quizzes.remove(i);
      }
    }
    for(int i = 0; i < students.size(); i++) {
      ArrayList<ArrayList<Float>> tempGrades = students.get(i).getGrades();
      int indexOfCourse = students.get(i).getCourseIndex(courseName);
      tempGrades.get(indexOfCourse).set(orderOfAssessments.indexOf(title), null);
    }
  }
  
  public void printAllQuizzesTitle() {
    for(int i = 0; i < this.quizzes.size(); i++) {
      this.quizzes.get(i).printTitle();
    }
  }
  
  public ArrayList<Student> getStudentList(){
    return students;
  }
  
  public void setStudentList(ArrayList<Student> students) {
    this.students =  students;
  }
  
  public Student findStudentByID(String studentID) {
    for(int i = 0; i < students.size(); i++) {
      if(students.get(i).getStudentID().equals(studentID)) return students.get(i);
    }
    return null;
  }
  
  public ArrayList<Instructor> getInstructorList(){
    return instructors;
  }
  
  public void setInstructorList(ArrayList<Instructor> instructors) {
    this.instructors =  instructors;
  }
  
  public void storeOrderOfAssessments(String title) {
    orderOfAssessments.add(title);
  }
  
  public void changeStudentGrade(String studentID, String title, float grade) {
    Student tempStudent = findStudentByID(studentID);
    ArrayList<ArrayList<Float>> tempGrades = tempStudent.getGrades();
    int indexOfCourse = tempStudent.getCourseIndex(courseName);
    tempGrades.get(indexOfCourse).set(orderOfAssessments.indexOf(title), grade);
  }
  
  
}