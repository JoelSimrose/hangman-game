//Joel Simrose
//Gallows Class
//September 25th, 2018

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.util.Arrays;


/**
*This is a class to show the ASCII hangman gallows as a user guesses incorrectly.
*/
public class Gallows
{

	int wrongGuess = 0;					//value to keep track of the number of wrong guesses
	String[] gallows = new String[7];	//string array to hold ASCII hangman 


	/**
	*This is the gallows constructor.
	*/
	public Gallows()
	{

	}

	/**
	*This is a method which is used to increment the number of times a user has guessed a wrong letter
	*/
	public void incrementHangman()
	{
		wrongGuess = wrongGuess+1;		//increment hangman 

	}

	/**
	*This is a method which checks whether the man has been hung or not(if he is dead)
	*@return returns false if there have been less than 7 guesses or true to end the game
	*/
	public boolean isDead()
	{
		if(wrongGuess < 7)		//
		{
			return false;
		}

		else
		{
			return true;
		}
	}


	/**
	*This is a method which determines what ASCII hangman art to output depending on how many incorrect guesses there have been
	*@return returns the string ASCII art 
	*/
	public String toString()
	{
	
		String[] gallowsOutput = {"\n"
		 +" ______\n"
		 +" |       |\n"
		 +"         |\n"
		 +"         |\n"
		 +"         |\n"
		 +"         |\n"
		+"=========\n", "\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +"         |\n"
		 +"         |\n"
		 +"         |\n"
		+"=========\n","\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +" |       |\n"
		 +"         |\n"
		 +"         |\n"
		+"=========\n", "\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +"/|       |\n"
		 +"         |\n"
		 +"         |\n"
		+"=========\n","\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +"/|       |\n"
		 +"/        |\n"
		 +"         |\n"
		+"=========\n", "\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +"/|\\      |\n"
		 +"/        |\n"
		 +"         |\n"
		+"=========\n", "\n"
		 +" ______\n"
		 +" |       |\n"
		 +"O      |\n"
		 +"/|\\      |\n"
		 +"/ \\      |\n"
		 +"         |\n"
		+"=========\n"};
			
		if(wrongGuess == 0)				//return different ASCII art depending on how many incorrect guesses there have been 
		{
			return gallowsOutput[0];
		}

		else if(wrongGuess == 1)
		{
			return gallowsOutput[1];
		}

		else if(wrongGuess == 2)
		{
			return gallowsOutput[2];
		}

		else if(wrongGuess == 3)
		{
			return gallowsOutput[3];
		}

		else if(wrongGuess == 4)
		{
			return gallowsOutput[4];
		}

		else if(wrongGuess == 5)
		{
			return gallowsOutput[5];
		}

		else if(wrongGuess == 6)
		{
			return gallowsOutput[6];
		}

		return gallowsOutput[0];
		
	}
}
