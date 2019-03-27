package dev.gudabayev.tamerlan;


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
	static ArrayList<Student> students = new ArrayList<Student>();
	
	static PrintWriter studentFile = null; {
	try {
		studentFile = new PrintWriter(new FileWriter("student.txt", true));
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
		System.out.println("Input Student Info: Name, Surname, ID, GPA");
		Student tempStu = new Student(keyboard.next(), keyboard.next(), keyboard.next(), keyboard.nextFloat());
		students.add(tempStu);
		
		for(int i = 0; i < students.size(); i++)
		{
			
			studentFile.println("Name:" + students.get(i).getName() +" " + students.get(i).getSurname() 
					+ " " +  "ID: " + students.get(i).getID() + " " + "GPA: " + students.get(i).getGPA() + "\n");
			System.out.println(students.get(0).getName());
			System.out.println(students.size());
			
		}
			
			studentFile.close();
	}
	public static String showStudent() 
	{
		return "\nName: " + name + "\n Surname: " + Surname + "\nID: "
				 + ID + "\n GPA: " + GPA + "\n";
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

