/**
 * @author Zachary Zampa
 * Compile the list of classes and their info
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GPAList {
    private ArrayList<ClassAndGrade> classes;

    public GPAList() {
        classes = new ArrayList <ClassAndGrade>();
    }

    public void addcourse(ClassAndGrade course) {
        classes.add(course);
    }

    public void listCourses() {
        if(classes.size() == 0)
            System.out.println("No classes added yet");
        else
        {
            System.out.println("Classes added to calculation list");
            for(ClassAndGrade course: classes)
                System.out.println(course);
        }
    }

    public double getGPA() {
        double GPA = 0.0;
        int creditTotal = 0;

        for(ClassAndGrade course : classes)
        {
            GPA += course.getClassGPA() * course.getClassCredits();
            creditTotal += course.getClassCredits();
        }

        GPA = GPA / creditTotal;

        return GPA;
    }

    public void saveToFile(String fileName) throws FileNotFoundException {
        PrintWriter fileOut = new PrintWriter (new File(fileName));
        // method call to save Calculation List to file

        double GPA = getGPA();

        fileOut.println("Cumulative GPA"); // file header
        fileOut.println("Course; GPA; Credits");

        for (ClassAndGrade course : classes) // begin printing Courses
        {
            fileOut.println(course);
        }

        fileOut.printf("\nCumulative GPA: %.2f", GPA);

        fileOut.close();

    }
    
    public void pullFromFile(String fileName) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(fileName));
        String className = null;
        double classGPA = -1.0;
        int classCredits = -1;
                
        while(fileIn.hasNext()) 
        {
            String[] split = fileIn.nextLine().split(";");
            
            className = split[0].trim();
            classGPA = Double.parseDouble(split[1].trim());
            classCredits = Integer.parseInt(split[2].trim());
            
            // add each course info to array list
            ClassAndGrade createdClass = new ClassAndGrade(className, classGPA, classCredits);
            classes.add(createdClass);
        }
        
        fileIn.close();
        
    }
    
}

