package dank;

import java.util.Scanner;
 
public class Tomuchdankforoneplace {

	static Scanner input = new Scanner(System.in);	
	static String username;
	static String choice;
	static int score;
	public static void main(String[] args) {
		askName();	
		startGame();
	}
	
	public static void askName()
	{
		print("Enter your name");
		username = takeInput();
		
	}
	public static void print(String str)
	{
		System.out.println(str);
	}
	public static String takeInput()
	{
		String entry = input.nextLine();
		return entry;
	}
	public static void startGame()
	{
		print(username + " walks in a swamp. Shrek comes out. What do you do?\n" +
				"|A|- 420BLAZEITNOSCPOPE\n" + "|B|- Run\n" + "|C|-360tomahawk\n");
		choice = takeInput();
		if(choice.equalsIgnoreCase("A"))
		{
			print("Shrek has been slain.");
			score = score + 2;
			pathA();
		}
		else if(choice.equalsIgnoreCase("B"))
		{
			print("Shrek angrily chases " + username + " but stops because he is fat and slow." );
			score = score + 1;
			pathB();
		}
		else if(choice.equalsIgnoreCase("C"))
		{
			print("It is ineffective. You just got shrekt.");
			ending();
		}
		else
		{
			print("Shrek takes " + username + " into his swamp and shreks him. The end.");
			ending();
		}
	}
	
	public static void pathA()
	{
		print(username + " now owns the swamp. Sanic comes to fight "+ username + " for it. What will " + username + " do?");
		sanicFight();
	}
	public static void pathB()
	{
		print(username + " runs into Sanic the Deformed Hedgehog. What will " + username + " do?");
		sanicFight();
	}
	public static void sanicFight()
	{
		print("|A| Run Away\n" + "|B|Taunt\n" + "|C|360FakeyFakeyNoscope\n" + "|D|CrossMapHackTomahawk\n");
		choice = takeInput();
		if(choice.equalsIgnoreCase("A"))
		{
			print("Sanic yells 'You're too slow'(queue sanic music) and eats " +username);
			ending();
		}
		else if(choice.equalsIgnoreCase("B"))
		{
			print("Sanic's becomes emotionally scarred and commits sucide.");
			score = score + 2;
			snoopDogFight();
		}
		else if(choice.equalsIgnoreCase("C"))
		{
			print(username + " noscopes Sanic and kills him.");
			score = score + 1;
			snoopDogFight();
		}
		else if(choice.equalsIgnoreCase("D"))
		{
			print("Sanic catches it and throws it back. " + username + " dies." );
			ending();
		}
		else
		{
			print(username +" doesn't do anything and kidnapped to be never seen again.");
			ending();
		}
	}
	public static void snoopDogFight()
	{
		print("Snoop Dog appears out of no where and challenges you to a fight. Snoop uses 'Rap' which makes him immune to stuff.\n");
		print("|A| Rap Battle\n" + "|B| Offer him weed\n" + "|C|Summon little kid to noscope him\n" + "|D|Run\n" );
		choice = takeInput();
		if(choice.equalsIgnoreCase("A")){
			print("You're not a rapper");
			score++;
			ending();
		}
		else if(choice.equalsIgnoreCase("B")){
			print("Snoopdog takes the weed and your walet too.");
			ending();
		}
		else if(choice.equalsIgnoreCase("C")){
			print("Little kid noscopes "+username+" instead.");
			ending();
		}
		else if(choice.equalsIgnoreCase("D")){
			print("Snoopdog teleports and robs you.");
			ending();
		}
		else{
			print("This isnt a choice pick again.");
			snoopDogFight();
		}
	}
	public static void ending(){
		if(score == 0)
		{
			print(score + ": you are a n00b.");
		}
		if(score == 1 || score == 2)
		{
			print(score + ": not mlg enough");
		}
		if(score == 3|| score == 4)
		{
			print(score + ": not dank enough for memes");
		}
		if(score == 5)
		{
			print(score + ": loominarty level");
		}
	}
		
}
	


