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
 * @version 23.10.2016
 */

public class STudent{
	static Scanner scan = new Scanner(System.in);  //input data from user through scanner class
    int Id;
    String Name;
    String Department;
    String University;
    double[][] GPA;  //row is for Year and coloumn is for Semister
    double CGPA;
    double gpa;
    String[] subjects;//string array for subjects of a term
    double[][][] credits; //First index for year & 2nd is for semester
    double[][][] grades; //First index for year & 2nd is for semester
    double gpa[][];

    public STudent(){
        Id=0;//default initialization
    	Name=null;//default initialization
    	Department=null;//default initialization
    	University=null;//default initialization
    	GPA=new double[4][2];//default initialization
    	CGPA=0.0;//default initialization
    	gpa=0.0;//default initialization
    	credits=new double[4][2][5];//default initialization
    	grades=new double[4][2][5];//default initialization
        gpa=new double[4][2];
    }


    public void studentDetailsById(int id){
        Id=id;
    	//System.out.println("ID:"+Id);//show id
    	System.out.println("Name:"+Name);//show name
    	System.out.println("University:"+University);//show university
    	System.out.println("Depertment:"+Department);//show department
    	//System.out.println("CGPA:"+CGPA);//show CGPA
    }


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


    public double computeCGPAByID(int id){
        Id=id;
        double CGPA;
        CGPA=gpa/8;//calculating CGPA

        return CGPA;
    }
    public double computeCGPAById(int id)
    {
    	Id=id;
    	double TCredit=0.0,result=0.0;
    	for(int i=0;i<8;i++)
    	{
    		for(int j=0;j<2;j++)
    		{
    			for(int k=0;k<5;k++)
    			{
    				System.out.println("Enter credit of "+(i+1)+" year" +(j+1)+" semister &"+(k+1)+" subject:");
                    credits[i][j][k]=scan.nextDouble();
                    TCredit+=credits[i][j][k];
                    System.out.println("Enter grades of "+(i+1)+" year" +(j+1)+" semister &"+(k+1)+" subject:");
                    grades[i][j][k]=scan.nextDouble();
                    result+=credits[i][j][k]*grades[i][j][k];
    			}
    			gpa[i][j]=result/TCredit;
    			System.out.println(gpa[i][j]);
    		}
    	}
    }
    public void saveStudent()throws IOException
    {
 	   FileWriter output=new FileWriter("output.txt");
 	   PrintWriter write=new PrintWriter(output);
 	   write.println("Name:"+ Name);
 	   write.println("University:"+ University);
 	   write.println("Department:"+ Department);
 	   write.println("TOTAL GPA:"+gpa);
 	   write.println("CGPA:"+CGPA);
 	   write.close();
    }

    public static void main(String[] args){
    	int n,Id;
    	double cg;
    	System.out.println("Enter Student Number: ");
    	n =scan.nextInt();
    	STudent[] student = new STudent[n]; //creating n objects of Class Student
    	for (int i = 0; i < n; i++) {
    		System.out.print("Enter ID no : ");
    		Id =scan.nextInt();
    		student[i] = new STudent(); //Allocate memory space for nth students
            try{
            student[i].updateStudentById(Id);//input student details
            student[i].studentDetailsById(Id);//showing details
            cg=student[i].computeCGPAByID(Id);//computing CGPA and showing results
            System.out.println("CGPA:"+cg);
            student[i].saveStudent();
            student[i].computeCGPAById(Id);
            }catch(IOException f)
            {
            System.err.println("problem in writing in file output.txt");
            }
            }
		}
    }
