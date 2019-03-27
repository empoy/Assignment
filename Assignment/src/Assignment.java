import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Assignment {
	
		static int menuScreen;
		String nameFirst;
		String nameLast;
		String identityNumber;
		String gradePoint;
		static ArrayList<String> words;
	
		
		public Assignment(String firstName, String surName, String id, String gpa)
		{
			nameFirst = firstName;
			nameLast = surName;
			identityNumber = id;
			gradePoint = gpa;
		}
		
		
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		Scanner keyboard = new Scanner(System.in);
		File student = new File("student.txt");
		File temp = new File("temp.txt");
		PrintWriter tempFile = new PrintWriter(new FileWriter(temp, false));
		PrintWriter studentFile = new PrintWriter(new FileWriter(student, true));
		Scanner read = new Scanner(student);
		String line1;
		
		
		
		do 
		{
		// Welcome Message
		System.out.println("Welcome please input what would you like to do:\n" 
				+ "1)Add Student\n" + "2)Remove Student\n" + "3)Update\n" + "4)Close Program \n");
		
		menuScreen = keyboard.nextInt();
		
		switch(menuScreen) 
		{
			case 1:
				System.out.println("Please Enter Studnet Details: Name, Surname,ID,GPA");
				Assignment student1 = new Assignment(keyboard.next(), keyboard.next(), keyboard.next(), keyboard.next());
				studentFile.append(student1.nameFirst + " " +  student1.nameLast + " " + student1.identityNumber
						+ " " + student1.gradePoint + "\n");
				System.out.println("Student Added Please Close Program to Update");
				TimeUnit.SECONDS.sleep(3);
				break;
			case 2:
				String lineToRemove = JOptionPane.showInputDialog(null, "Enter a word to remove");
				line1 = read.next();
				
				while(read.hasNext())
				{
					if(line1.contains(lineToRemove))
					{
						break;
						
						
					}
					else {
						
							
							words.add(line1);
						
					}
					line1 = read.next();
					
					
				}
				
				break;
			case 3:
				
				break;
					
		}
		}while(menuScreen != 4);
		
		
		tempFile.close();
		read.close();
		keyboard.close();
		studentFile.close();
		
		
		
		
		
	}
	
	

}
