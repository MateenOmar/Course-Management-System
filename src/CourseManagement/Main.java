package CourseManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("If your school file already exists, please enter its name.\nIf not, please enter your schools name: ");
    String input = sc.nextLine();

    File schoolFile = new File(input);
    School school = null;

    if(schoolFile.exists()) {

      try
      {    
        FileInputStream file = new FileInputStream(input); 
        ObjectInputStream in = new ObjectInputStream(file); 

        school = (School)in.readObject(); 
        
        in.close(); 
        file.close(); 
      }   
      catch(IOException e) 
      { 
        System.out.println("IOException is caught"); 
        e.printStackTrace();
        return;
      } catch (ClassNotFoundException e) {
        System.out.println("ClassNotFoundException is caught"); 
        return;
      } 

    }
    else {
      school = School.createInstanceOfSchool(input);
    }

    Interaction interaction = new Interaction(school);

    while(true) {
      System.out.println("\nEnter 'quit' as ID and password to save and quit session");
      System.out.print("Enter Your ID: ");
      String id = sc.nextLine();
      System.out.print("Enter Your Password: ");
      String password = sc.nextLine();

      if(id.equals("quit") && password.equals("quit")) {
        break;
      }

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

    } 

    try
    {    
      FileOutputStream file = new FileOutputStream(input + ".ser"); 
      ObjectOutputStream out = new ObjectOutputStream(file); 

      out.writeObject(school); 
      
      out.close(); 
      file.close(); 
    } 
    catch(IOException e) 
    { 
      System.out.println("IOException is caught"); 
    } 

    sc.close();
  }

}
