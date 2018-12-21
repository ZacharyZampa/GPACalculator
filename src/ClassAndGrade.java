/**
 * @author Zachary Zampa
 * Create the template for creating a class and the grade received in the class
 */
public class ClassAndGrade {
    private double classGPA;
    private String className;
    private int classCredits;
    
    
    //The class and GPA constructor
    public ClassAndGrade(String className, double classGPA, int classCredits) {
	this.setClassName(className);
	this.setClassGPA(classGPA);
	this.setClassCredits(classCredits);
    } // end ClassAndGrade constructor
    
    
    public String getClassName() {
	return className;
    }
    
    public double getClassGPA() {
	return classGPA;
    }
    
    public int getClassCredits() {
	return classCredits;
    }
    
    
    public void setClassName(String className) {
	this.className = className;
    }
    
    public void setClassGPA(double classGPA) {
	this.classGPA = classGPA;
    }
    
    public void setClassCredits(int classCredits) {
	this.classCredits = classCredits;
    }
    
    
    // allow for printing of class and corresponding info
    public String toString() {
	return this.getClassName() + "; " +
		this.getClassGPA() + "; " +
		this.getClassCredits();
	
    }
    
    
}
