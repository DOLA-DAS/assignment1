import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
/**
 * This is a class to define the necessary attributes and methods to conceptualize a "Student"
 * The spepcific tasks are:
 * 1. Instiate
 *
 * @author Dola Das
 * @version 17.10.2016
 */

public class Student{
	static Scanner scan = new Scanner(System.in);  //input data from user through scanner class
    int Id;
    String Name;
    String Department;
    String University;
    double[][] GPA;  //row is for Year and coloumn is for Semister
    double CGPA;
    double gpa;
    String[] subjects;//string array for subjects of a term
    double[][][] credits; //First index for year 2nd is for semester & 3rd is for Subject number
    double[][][] grades; //First index for year 2nd is for semester & 3rd is for Subject number

    /**
     * Define a constructor that initilize the default properties of the Student
     */
    public Student(){
        Id=0;//default initialization
    	Name=null;//default initialization
    	Department=null;//default initialization
    	University=null;//default initialization
    	GPA=new double[4][2];//default initialization
    	CGPA=0.0;//default initialization
    	gpa=0.0;//default initialization
    	credits=new double[4][2][12];//default initialization
    	grades=new double[4][2][12];//default initialization

    }
    /**
     * Define a method to print the students details.
     */

    public void studentDetailsById(int id){
        Id=id;
    	//System.out.println("ID:"+Id);//show id
    	System.out.println("Name:"+Name);//show name
    	System.out.println("University:"+University);//show university
    	System.out.println("Depertment:"+Department);//show department
    	//System.out.println("CGPA:"+CGPA);//show CGPA
    }

    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    public double updateStudentById(int id){
    	Id = id;
    	scan.nextLine();//for "enter" button
    	System.out.println("Enter name : ");
    	Name = scan.nextLine();//input name
    	System.out.println("Enter University : ");
    	University = scan.nextLine();//input university
    	System.out.println("Enter Department : ");
    	Department = scan.nextLine();//input department
    	for(int i=0;i<8;i++)
    	{
    		System.out.println("Enter GPA of " + (i+1) + " semister :  ");//input GPA
    		gpa= gpa+scan.nextDouble();//calculating total GPA
    	}
    	return gpa;

    }

    /**
     * Define a method to compute the CGPA from the Given term GPA for a particular student.
     * se as many arguments as required.
     */
    public void computeCGPAByID(int id){
        Id=id;
        double CGPA;
        CGPA=gpa/8;//calculating CGPA
    	System.out.println(CGPA);
    }
    /**
     * The tasks to be carried out here:
     * 1. Create an Arrays of students using Student Class. Initlize them and perfom all the above defined operation to evualuate your code.
     * use as many arguments as required.
     */
    public static void main(String[] args){
    	int n,Id;
    	System.out.println("Enter Student Number: ");
    	n =scan.nextInt();
    	Student[] student = new Student[n]; //creating n objects of Class Student
    	for (int i = 0; i < n; i++) {
    		System.out.print("Enter ID no : ");
    		Id =scan.nextInt();
    		student[i] = new Student(); //Allocate memory space for nth students
            student[i].updateStudentById(Id);//input student details
            student[i].studentDetailsById(Id);//showing details
            student[i].computeCGPAByID(Id);//computing CGPA and showing results

            }
		}
    }
