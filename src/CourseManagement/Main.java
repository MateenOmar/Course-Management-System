package CourseManagement;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("If your school file already exists, please enter its name.\nIf not, please enter your schools name: ");
    String input = sc.nextLine();
    
    File schoolFile = new File(input);
    School school;
    
    if(schoolFile.exists()) {
      //Have to read file here, and from there fill in all the saved details back into objects
      String schoolName = "";
      school = School.createInstanceOfSchool(schoolName);
    }
    else {
      school = School.createInstanceOfSchool(input);
    }
    
    Interaction interaction = new Interaction(school);
    
    //while(input.equals("exit")) {//Change condition
      System.out.print("Enter your id: ");
      String id = sc.nextLine();
      System.out.print("Enter your password: ");
      String password = sc.nextLine();
      
      Matcher matcher = Pattern.compile("\\d+").matcher(id);
      
      if(matcher.find()) {
        int number = Integer.valueOf(matcher.group());
        
        if(number >= 5555) {
          
          for(Student student : school.getStudents()) {
            if(student.getStudentID().equals(id) && student.getIdPassword().equals(password)) {
              interaction.studentInterface(student);
            }
          }
          
        }
        else {

          for(Instructor instructor : school.getInstructors()) {
            if(instructor.getInstructorID().equals(id) && instructor.getIdPassword().equals(password)) {
              interaction.instructorInterface(instructor);
            }
          }
          
        }
        
      }
      else {
        
        if(id.equals(school.getSchoolName()) && password.equals(school.getIdPassword())) {
          interaction.schoolInterface();
        }
        else {
          
          for(Administrator admin : school.getAdmins()) {
            if(admin.getAdminID().equals(id) && admin.getIdPassword().equals(password)) {
              interaction.adminInterface(admin);
            }
          }
          
        }
        
      }
      
      
    //}
    
    sc.close();
  }

}
