package CourseManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Interaction implements Serializable{

  private School school;

  public Interaction(School school) {
    this.school = school;
  }

  public void studentInterface(Student student) {
    Scanner sc = new Scanner(System.in);
    String input;
    
do {
      
      System.out.println("\n1. Courses");
      System.out.println("2. Change Password");
      System.out.println("3. Logout");
      System.out.print("Enter Number: ");
      input = sc.nextLine();
      
      switch(input) {
        case "1":    
          for(Course courses : student.getEnrolledCourses()) {
            System.out.println(courses.getCourseName());
          }
          System.out.println("Back To Homepage");
          System.out.print("Enter The Course Name: ");
          String courseName = sc.nextLine();
          
          if(!courseName.equals("Back To Homepage")) {
            for(Course courses : student.getEnrolledCourses()) {
              if(courseName.equals(courses.getCourseName())) {
                
                do {   
                  System.out.println("\n1. Announcements");
                  System.out.println("2. Assignments");
                  System.out.println("3. Quizzes");
                  System.out.println("4. Make Announcement");
                  System.out.print("Enter Number: ");
                  input = sc.nextLine();
                  System.out.println("\n");
                  
                  switch(input) {
                    case "1":
                      for(int i = 0; i < courses.getAnnouncements().size(); i++) {
                        System.out.println((i+1) + ". " + courses.getAnnouncements().get(i));
                      }
                      break;
                      
                    case "2":
                      courses.printAllAssignmentsTitle();
                      break;
                      
                    case "3":
                      courses.printAllQuizzesTitle();
                      break;
                      
                    case "4":
                      break;
                      
                    default: 
                      System.out.println("Invalid Option");
                  }

                } while(!input.equals("4"));
                
                break;
              }
            }
          }
          break;
          
        case "2":
          System.out.print("Enter New Password: ");
          String idPassword = sc.nextLine();
          student.setIdPassword(idPassword);
          break;
          
        case "3":
          System.out.println("Logout Successful");
          System.out.println("\n");
          break;
          
        default: 
          System.out.println("Invalid Option");
      }

    } while(!input.equals("3"));
    
  }

  public void instructorInterface(Instructor instructor) {
    Scanner sc = new Scanner(System.in);
    String input;
    
    do {
      
      System.out.println("\n1. Courses");
      System.out.println("2. Change Password");
      System.out.println("3. Logout");
      System.out.print("Enter Number: ");
      input = sc.nextLine();
      
      switch(input) {
        case "1":
          for(Course courses : instructor.getInstructorForCourses()) {
            System.out.println(courses.getCourseName());
          }
          System.out.println("Back To Homepage");
          System.out.print("Enter The Course Name: ");
          String courseName = sc.nextLine();
          
          if(!courseName.equals("Back To Homepage")) {
            for(Course courses : instructor.getInstructorForCourses()) {
              if(courseName.equals(courses.getCourseName())) {
                
                do {   
                  System.out.println("\n1. Announcements");
                  System.out.println("2. Assignments");
                  System.out.println("3. Quizzes");
                  System.out.println("4. Make Announcement");
                  System.out.println("5. Add Assignment");
                  System.out.println("6. Add Quiz");
                  System.out.println("7. Add Grade");
                  System.out.println("8. Edit Grade");
                  System.out.println("9. Remove Assignment");
                  System.out.println("10. Remove Quiz");
                  System.out.println("11. Back To Homepage");
                  System.out.print("Enter Number: ");
                  input = sc.nextLine();
                  System.out.println("\n");
                  
                  switch(input) {
                    case "1":
                      for(int i = 0; i < courses.getAnnouncements().size(); i++) {
                        System.out.println((i+1) + ". " + courses.getAnnouncements().get(i));
                      }
                      break;
                      
                    case "2":
                      courses.printAllAssignmentsTitle();
                      break;
                      
                    case "3":
                      courses.printAllQuizzesTitle();
                      break;
                      
                    case "4":
                      System.out.print("Enter The Announcement: ");
                      String announcement = sc.nextLine();
                      ArrayList<String> announcementsCopy = courses.getAnnouncements();
                      announcementsCopy.add(announcement);
                      break;
                      
                    case "5":
                      System.out.print("Enter The Assignment Title: ");
                      String aTitle = sc.nextLine();
                      System.out.print("Enter The Assignment Content: ");
                      String aNote = sc.nextLine();
                      courses.addAssignment(aTitle, aNote);
                      break;
                      
                    case "6":
                      System.out.print("Enter The Quiz Title: ");
                      String qTitle = sc.nextLine();
                      System.out.print("Enter The Quiz Content: ");
                      String qNote = sc.nextLine();
                      System.out.print("Enter The Time Limit: ");
                      int timeLimit = Integer.parseInt(sc.nextLine());
                      courses.addQuiz(qTitle, qNote, timeLimit);
                      break;
                      
                    case "7":
                      break;
                      
                    case "8":
                      System.out.print("Enter The Student's Student ID: ");
                      String studentID = sc.nextLine();
                      System.out.print("Enter The Assignment/Quiz Title: ");
                      String title = sc.nextLine();
                      System.out.print("Enter The New Mark: ");
                      int newMark = Integer.parseInt(sc.nextLine());
                      courses.changeStudentGrade(studentID, title, newMark);
                      break;
                      
                    case "9":
                      System.out.print("Enter The Assignment Title: ");
                      String titleA = sc.nextLine();
                      courses.removeAssignment(titleA);
                      break;
                      
                    case "10":
                      System.out.print("Enter The Quiz Title: ");
                      String titleQ = sc.nextLine();
                      courses.removeQuiz(titleQ);
                      break;
                      
                    case "11":
                      break;
                      
                    default: 
                      System.out.println("Invalid Option");
                  }

                } while(!input.equals("11"));
                
                break;
              }
            }
          }
          
          break;
          
        case "2":
          System.out.print("Enter New Password: ");
          String idPassword = sc.nextLine();
          instructor.setIdPassword(idPassword);
          break;
          
        case "3":
          System.out.println("Logout Successful");
          System.out.println("\n");
          break;
          
        default: 
          System.out.println("Invalid Option");
      }

    } while(!input.equals("3"));
  }

  public void adminInterface(Administrator admin) {
    Scanner sc = new Scanner(System.in);
    String input;
    
    do {  
      System.out.println("\n1. Add Student To School");
      System.out.println("2. Add Instructor To School");
      System.out.println("3. Add Student To A Course");
      System.out.println("4. Add Instructor To A Course");
      System.out.println("5. Remove Student From School");
      System.out.println("6. Remove Instructor From School");
      System.out.println("7. Remove Student From A Course");
      System.out.println("8. Remove Instructor From A Course");
      System.out.println("9. Change Password");
      System.out.println("10. Logout");
      System.out.print("Enter Number: ");
      input = sc.nextLine();
      
      switch(input) {
        case "1":
          System.out.print("Student's First Name: ");
          String firstName = sc.nextLine();
          System.out.print("Student's Last Name: ");
          String lastName = sc.nextLine();
          admin.addStudent(firstName, lastName);
          break;
          
        case "2":
          System.out.print("Instructor's First Name: ");
          String firstName2 = sc.nextLine();
          System.out.print("Instructor's Last Name: ");
          String lastName2 = sc.nextLine();
          admin.addInstructor(firstName2, lastName2);
          break;
          
        case "3":
          System.out.print("Student's Student ID: ");
          String studentID = sc.nextLine();
          System.out.print("Course Name: ");
          String courseName = sc.nextLine();
          admin.addStudentToCourse(studentID, courseName);
          break;
          
        case "4":
          System.out.print("Instructor's Student ID: ");
          String instructorID = sc.nextLine();
          System.out.print("Course Name: ");
          String courseName2 = sc.nextLine();
          admin.addInstructorToCourse(instructorID, courseName2);
          break;
          
        case "5":
          System.out.print("Student's Student ID: ");
          String studentID2 = sc.nextLine();
          admin.removeStudent(studentID2);
          break;
          
        case "6":
          System.out.print("Instructor's Student ID: ");
          String instructorID2 = sc.nextLine();
          admin.removeInstructor(instructorID2);
          break;
          
        case "7":
          System.out.print("Student's Student ID: ");
          String studentID3 = sc.nextLine();
          System.out.print("Course Name: ");
          String courseName3 = sc.nextLine();
          admin.removeStudentFromCourse(studentID3, courseName3);
          break;
          
        case "8":
          System.out.print("Instructor's Student ID: ");
          String instructorID3 = sc.nextLine();
          System.out.print("Course Name: ");
          String courseName4 = sc.nextLine();
          admin.removeInstructorFromCourse(instructorID3, courseName4);
          break;
          
        case "9":
          System.out.print("Enter New Password: ");
          String idPassword = sc.nextLine();
          admin.setIdPassword(idPassword);
          break;
          
        case "10":
          System.out.println("Logout Successful");
          System.out.println("\n");
          break;
          
        default: 
          System.out.println("Invalid Option");
      }

    } while(!input.equals("10"));
  }
  
  public void schoolInterface() {
    Scanner sc = new Scanner(System.in);
    String input;
    
    do {    
      System.out.println("\n1. Add Course");
      System.out.println("2. Add Administrator To School");
      System.out.println("3. List All Offered Courses");
      System.out.println("4. List All Administrators");
      System.out.println("5. List All Instructors");
      System.out.println("6. List All Students");
      System.out.println("7. Change Password");
      System.out.println("8. Logout");
      System.out.print("Enter Number: ");
      input = sc.nextLine();
      
      switch(input) {
        case "1":
          System.out.print("Course Name: ");
          String courseName = sc.nextLine();
          boolean exists = false;
          
          for(Course course : school.getOfferedCourses()) {
            if(course.getCourseName().equals(courseName)) {
              System.out.println("Course " + courseName + " already exists");
              exists = true;
              break;
            }
          }
          
          if(!exists) {
            school.addCourse(courseName); 
          }
          break;
          
        case "2":
          System.out.print("Admin's First Name: ");
          String firstName = sc.nextLine();
          System.out.print("Admin's Last Name: ");
          String lastName = sc.nextLine();
          school.addAdministrator(firstName, lastName);
          break;
          
        case "3":
          System.out.println("Courses:");
          for(Course course : school.getOfferedCourses()) {
            System.out.println(course.getCourseName());
          }
          break;
          
        case "4":
          System.out.println("Administrators:");
          for(Administrator admin : school.getAdmins()) {
            System.out.println(admin.getFullName());
          }
          break;
          
        case "5":
          System.out.println("Instructors:");
          for(Instructor instructor : school.getInstructors()) {
            System.out.println(instructor.getFullName());
          }
          break;
          
        case "6":
          System.out.println("Students:");
          for(Student student : school.getStudents()) {
            System.out.println(student.getFullName());
          }
          break;
          
        case "7":
          System.out.print("Enter New Password: ");
          String idPassword = sc.nextLine();
          school.setIdPassword(idPassword);
          break;
          
        case "8":
          System.out.println("Logout Successful");
          System.out.println("\n");
          break;
          
        default: 
          System.out.println("Invalid Option");
      }

    } while(!input.equals("8"));
  }

}
