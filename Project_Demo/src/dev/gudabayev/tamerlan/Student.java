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
	
	String Name;
	String Surname;
	String ID;
	static String searchID;
	static int index;
	float GPA;
	static Scanner keyboard = new Scanner(System.in);
	static ArrayList<Student> students = new ArrayList<Student>();
	
	
	
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
		Name = name;
		Surname = surname;
		ID = iD;
		GPA = gPA;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		name = name;
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
	
	public static void addStudent() throws IOException 
	{
		file.delete();
		file.createNewFile();
		System.out.println("Input Student Info: Name, Surname, ID, GPA");
		Student tempStu = new Student(keyboard.next(), keyboard.next(), keyboard.next(), keyboard.nextFloat());
		students.add(tempStu);
		int counter = 0;
		while(counter < students.size())
		{
			studentFile.print(students.get(counter).getName() + " " + students.get(counter).getSurname() 
					 + " " + students.get(counter).getID() + " " + students.get(counter).getGPA() + "\n");	
			counter++;
		}
		
		studentFile.flush();
		studentFile.close();
	}
	public static Student showStudent(Student temp) throws FileNotFoundException 
	{
		Scanner reader = new Scanner(file);
		ArrayList<Student> students = new ArrayList<Student>();
		System.out.println("Enter Students ID that you wanna check for");
		searchID = keyboard.nextLine();
		
		
		if(reader.hasNext()) {
			while(reader.hasNext()) 
			{
			students.add(new Student(reader.next(), reader.next(), reader.next(), reader.nextFloat()));
			}
			
			for(int i = 0;i < students.size(); i++)
			{
				if(searchID.equals(students.get(i).getID())) {
					 System.out.println(students.get(i).getName() + " " + students.get(i).getSurname() 
					 + " " + students.get(i).getID() + " " + students.get(i).getGPA() + "\n");
					 index = i;
					 temp = students.get(i);
					return temp;
				}
				}
				
			
				System.out.println("Student Not Found");
		}
		else {
			System.out.println("Your File is Empty");
		}
		return temp;
	}
	public static void updateStudent() throws IOException 
	{
		Scanner reader= new Scanner(file);
		ArrayList<Student> students = new ArrayList<Student>();
		Student tempStudent = new Student("a", "a", "a", 3);
		String answer;
		
		
		if(reader.hasNext()) {
			while(reader.hasNext()) 
			{
			students.add(new Student(reader.next(), reader.next(), reader.next(), reader.nextFloat()));
			}
		}
		
		tempStudent = showStudent(tempStudent);
		
		System.out.println("Are you sure you want to update this student? y/n");
		answer = keyboard.nextLine();
		if(answer.equals("y") || answer.equals("Y")) {
			file.delete();
			file.createNewFile();
			System.out.println("Please Input Replaced Student: Name, Surname, ID, GPA");
			students.set(index, new Student(keyboard.next(), keyboard.next(), keyboard.next(), keyboard.nextFloat()));
			
			for(int i = 0; i < students.size(); i++)
			{
				System.out.print(students.get(i).getName() + " " +students.get(i).getID() + "\n");
			}
			int counter = 0;
			while(counter < students.size())
			{
				studentFile.print(students.get(counter).getName() + " " + students.get(counter).getSurname() 
						 + " " + students.get(counter).getID() + " " + students.get(counter).getGPA() + "\n");	
				counter++;
			}
			studentFile.flush();
			studentFile.close();
			
		}
		else {
			System.out.println("Okay, no change will occur");
		}
			
		reader.close();
	}
	public static void deleteStudent() throws IOException 
	{
		Scanner reader= new Scanner(file);
		ArrayList<Student> students = new ArrayList<Student>();
		Student tempStudent = new Student("a", "a", "a", 3);
		String answer;
		
		if(reader.hasNext()) {
			while(reader.hasNext()) 
			{
			students.add(new Student(reader.next(), reader.next(), reader.next(), reader.nextFloat()));
			}
		}
		
		tempStudent = showStudent(tempStudent);
		
		System.out.println("Are you sure you want to delete this student? y/n");
		answer = keyboard.nextLine();
		if(answer.equals("y") || answer.equals("Y")) 
		{
			students.remove(index);
			//file.delete();
			//file.createNewFile();
			studentFile = new PrintWriter(new FileWriter(file, false));
			
			int counter = 0;
			while(counter < students.size())
			{
				studentFile.append(students.get(counter).getName() + " " + students.get(counter).getSurname() 
						 + " " + students.get(counter).getID() + " " + students.get(counter).getGPA() + "\n");	
				counter++;
			}
			
			
			
		}
		else {
			System.out.println("Okay, no change will occur");
		}
		
		studentFile.flush();
		studentFile.close();
		reader.close();
	}
	public static void showGPA() {
	
	}

}
