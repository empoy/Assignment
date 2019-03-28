package dev.gudabayev.tamerlan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Methods {

	
	//This methods is used at the beginning of the program.
	public static void Lanuch() throws FileNotFoundException 
	{
		Scanner keyboard = new Scanner(System.in);
		int numberForMenu;
		
		System.out.println("Welcome to Student Database System");
		System.out.println("What would you like to do? \n" 
				 + "1)Add "
				 + "2)Show " + "3)Update \n"
				 + "4)Delete " + "5)Show GPA"
				 + " 6)Close");
		
		do {
			numberForMenu = keyboard.nextInt();
			if(numberForMenu > 6 || numberForMenu <= 0) 
			{
				System.out.println("Please Input Number between 1-6");
			}
			else 
			{			
				Menu(numberForMenu);
			}
			
		}while(numberForMenu != 6);
	
		keyboard.close();
		
	}
	
	public static void Menu(int n) throws FileNotFoundException {
		switch(n) {
			case 1: 
				Student.addStudent();
				break;
			case 2: 
				Student.showStudent();
				break;
			case 3: 
				Student.updateStudent();
				break;
			case 4: 
				Student.deleteStudent();
				break;
			case 5: 
				Student.showGPA();
				break;
			case 6: 
				break;
		}
	}
}
