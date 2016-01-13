package introduction;

import java.util.Scanner;

public class HelloWorld {
	/** @param args
	 */
	/** this isnt code 
	 */
	static int numberOfMessages;
	static Scanner input = new Scanner(System.in);	
	static String username;
	static boolean running;
	
	public static void main(String[] args) {
//		print("Hello World"); 
//		/** ^^ overloaded -> same method with different arguments 
//		  */
//		print(1+2); 
//		String message = "This is a message signed to messsage";
//		print(message);
//		int number1 = 6;
//		int number2 = 9;
//		print(number1+number2); 
//		print("The numbers are " + number1 + " and " +
//				 number2 + "."+ " Their" + " sum is " + (number1 + number2));
//		/**
//		for(int c = 0; c < 10; c = c+1)
//		{
//			System.out.print("The numbers are " + number1 + " and " +
//			number2 + "."+ " Their" + " sum is " + (number1 + number2));
//			
//		}
//		
//		Scanner user_input = new Scanner(System.in);
//		String name;
//		print("Enter name->");
//		name = user_input.next();
//		print("Hello! " + name);
//		*/
//		promptName();
//		print("What is your favorite animal?");
//		String favoriteAnimal = waitForInput();
//		print("Wow that sure is great," + username + ". I love " + favoriteAnimal
//				+ " too! Want to know what else you like?");
//		String userinput1 = waitForInput();
//		print("DEEEZ NUTS!!! @__@ ");
		promptName();
		endlessConversation();
		
	}
	 
	public static void endlessConversation()
	{
		running = true;
		while(running)
		{
			print("What school do you go to?");
			String school = waitForInputProvideChoices();
			if(school.equals("S"))
			{
				talkAboutBread();
			}
			else if(school.equals("Q"))
			{
				running = false;
				
			}
			else
			{
				print("Oh, so you go to " + school);
			}
			
		//	print("Oh so you go to"+ waitForInput()+ "?");
			
		}
	}
	
	public static void talkAboutBread()
	{
		print("I like bread. Yum!");
	}
	
	public static String waitForInputProvideChoices()
	{
		print("You may type the following commands:\n" +
				" \"Q\" - to quit\n" +
				" \"S\" - startover");
		String entry = input.nextLine();
		return entry;
	
	}
	public static void print(int i)
	{
		numberOfMessages++;
		System.out.println(numberOfMessages + "th message " + i);
	}
	
	public static void print(String string)
	{
		numberOfMessages++;
		System.out.println(numberOfMessages + "th message :"+string );
	}
	public static String waitForInput()
	{
		String entry = input.nextLine();
		return entry;
	}
	public static void promptName()
	{
		print("Please enter your name,");
		username = waitForInput();
		print("Okay, I will call you "+ username);
	}
	
}



