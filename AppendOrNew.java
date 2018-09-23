//Developed by Aemun Ahmar 1047508
//CSCI 185-M03: Spring 2017
//Professor Hakkan Peckan
//Ckasswork 4: Append or New
//March 10, 2017

import java.io.*;
import java.util.*;

public class AppendOrNew 
{
	public static void main(String[] args)
	{
		PrintWriter outputStream = null;
		
		System.out.println("Enter the text that you want to enter: ");
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		
		System.out.println("Select operation: append, new, or nothing");
		String operationType = input.nextLine();
		
		System.out.println("Enter the name of the file: ");
		String fileName = input.nextLine();
		
		try
		{
			if(operationType.equals("append"))
			{
				outputStream = new PrintWriter(new FileOutputStream(fileName, true));
				outputStream.println(text);
				outputStream.close();
				
				System.out.println("Those lines were written to " + fileName);
			} else if(operationType.equals("new"))
			{
				outputStream = new PrintWriter(fileName);
				outputStream.println(text);
				outputStream.close();
				
				System.out.println("Those lines were written to " + fileName);
			} else if(operationType.equals("nothing"))
			{
				System.out.println("No changes have been made to file: " + fileName);
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File " + fileName + " not found. Program will now terminate.");
			System.exit(0);
		}
		
		Scanner inputStream = null;
		
		System.out.println("\nEnter the name of the file you want to read: ");
		String readFile = input.nextLine();
		System.out.println();
		
		try
		{
			inputStream = new Scanner(new File(readFile));
		} catch(IOException e)
		{
			System.out.println("File not found. Program will now terminate");
			System.exit(0);
		}
		
		try
		{
			System.out.println("Enter the name of the new file you want to create");
			String newFile = input.nextLine();
			System.out.println();
			
			outputStream = new PrintWriter(newFile);
			
			while(inputStream.hasNextLine())
			{
				String line = inputStream.nextLine();
				outputStream.write(line);
				System.out.println(line);
			}
		} catch(IOException e)
		{
			System.out.println("File " + fileName + " not found. Program will now terminate.");
			System.exit(0);
		}
		inputStream.close();
		input.close();
	}
}
