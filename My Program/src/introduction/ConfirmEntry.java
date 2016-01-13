package introduction;

import java.util.Scanner;


public class ConfirmEntry {

	static Scanner input = new Scanner(System.in);
	static String userInput;
	static String userConfirm;
	static String userIn;
	static String userCon;
	public static void main(String[] args) {
		operation();
	}
	public static String takeInput()
	{
		String entry = input.nextLine();
		return entry;
	}
	public static void operation()
	{
		boolean on = true;
		System.out.println("What is your favorite color?");
		userInput = takeInput();
		System.out.println("Are you sure your favorite color is "+ userInput + "? Type 'YES' if sure.");
		userConfirm = takeInput();
		while(on){
		if(userConfirm.equalsIgnoreCase("YES"))
		{
			System.out.println("Your color " + userInput + " has been confirmed");
			on = false;
		}
		else 
		{
			System.out.println("Color not confirmed, restarting");
			System.out.println("What is your favorite color?");
			userInput = takeInput();
			System.out.println("Are you sure your favorite color is "+ userInput + "? Type 'YES' if sure.");
			userConfirm = takeInput();
		}
		}
		operation2();
		
	}
public static void operation2()
{
	boolean on1 = true;
	System.out.println("What is your name?");
	userIn = takeInput();
	System.out.println("Are you sure your favorite name is "+ userIn + "? Type 'YES' if sure.");
	userCon = takeInput();
	while(on1){
	if(userCon.equalsIgnoreCase("YES"))
	{
		System.out.println("Your name " + userIn + " has been confirmed");
		on1 = false;
	}
	else 
	{
		System.out.println("Name not confirmed, restarting");
		System.out.println("What is your name?");
		userIn = takeInput();
		System.out.println("Are you sure your favorite name is "+ userIn + "? Type 'YES' if sure.");
		userCon = takeInput();
	}
	}
	ending();
}
public static void ending()
{
	System.out.println("Your name is " + userIn + " and your favorite color is " + userInput);
}
}
