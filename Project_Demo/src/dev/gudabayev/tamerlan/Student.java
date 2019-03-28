package dev.gudabayev.tamerlan;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	private static String name;
	private static String Surname;
	private static String ID;
	private static float GPA;
	static Scanner keyboard = new Scanner(System.in);
	
	
	
	static File file = new File("student.txt");
	static PrintWriter studentFile = null; {
	try {
		studentFile = new PrintWriter(new FileWriter(file, true));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	
	public Student(String name, String surname, String iD, float gPA) {
		Student.name = name;
		Surname = surname;
		ID = iD;
		GPA = gPA;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		Student.name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public float getGPA() {
		return GPA;
	}
	public void setGPA(float gPA) {
		GPA = gPA;
	}
	
	public static void addStudent() 
	{
		ArrayList<Student> students = new ArrayList<Student>();
		System.out.println("Input Student Info: Name, Surname, ID, GPA");
		Student tempStu = new Student(keyboard.next(), keyboard.next(), keyboard.next(), keyboard.nextFloat());
		students.add(tempStu);
		
		for(int i = 0; i < students.size(); i++)
		{
			
			studentFile.append(students.get(i).getName() + " " + students.get(i).getSurname() 
					 + " " + students.get(i).getID() + " " + students.get(i).getGPA() + "\n");	
		}
			
			studentFile.close();
	}
	public static void showStudent() throws FileNotFoundException 
	{
		Scanner reader = new Scanner(file);
		ArrayList<Student> students = new ArrayList<Student>();
		
		if(reader.hasNext()) {
			while(reader.hasNext()) 
			{
			students.add(new Student(reader.next(), reader.next(), reader.next(), reader.nextFloat()));
			}
			
			for(int i = 0; i < students.size(); i++)
			{
				System.out.println(students.get(i).getSurname());
			}
			System.out.println(students.size());
		}
		else {
			System.out.println("Your File is Empty");
		}
		
	
		String SearchID;
		//System.out.println("Enter Students ID");
		//SearchID = keyboard.next();
	}
	public static void updateStudent() 
	{
		
	}
	public static void deleteStudent() 
	{
	
	}
	public static void showGPA() {
	
	}

}

