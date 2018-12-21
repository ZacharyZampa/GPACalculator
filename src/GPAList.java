/**
 * @author Zachary Zampa
 * Compile the list of classes and their info
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
}

