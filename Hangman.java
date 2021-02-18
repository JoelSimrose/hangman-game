//Joel Simrose
//Hangman Class
//September 25th, 2018

import java.util.*;
import java.lang.*;
import javax.swing.*;

/**
*This is a class which allows the user to play the game hangman. 
*/
public class Hangman
{
	private Message message;
	private Gallows gallows;

	/**
	*This creates a new hangman object to start the game
	*/
	public static void main(String[] args)
	{	
	 		
	 	new Hangman();	//create new Hangman Object 

	}	

	/**
	*This is a hangman constructor which gets user input and uses the message class and gallows class to play hangman 
	*/
	public Hangman()
	{
		String guess = null;

		message = new Message();	//create a new message and gallows class for hangman
		gallows = new Gallows();


		while(!gallows.isDead() && !message.solved())	//keep asking for letters until solved or dead
		{
			while(guess == null || guess.length() == 0)	//make sure letter is not null and bigger than zero before submitting 
			{
				guess = JOptionPane.showInputDialog(null, "Please guess a letter: \n"+message.show(message.hiddenWord)+"\n"+gallows.toString(),"Hangman Game", JOptionPane.QUESTION_MESSAGE);
			}

			guess = guess.toLowerCase();	//make guess case insensitive

			Character guessCharacter = guess.charAt(0); //take first character in guess

			if(!message.guess(guessCharacter)) //pass guess in to check for a match
			{
				gallows.incrementHangman(); // if there is a match increment hangman
			}

			guess = null;	
			
		}


		if(gallows.isDead())	//messages to let user know if they won or lost and if they would like to play again or not
		{
			int loseContinuePlaying = JOptionPane.showConfirmDialog(null,"You lose. \n Would you like to play again?", null, JOptionPane.YES_NO_OPTION);
		
			if(loseContinuePlaying == JOptionPane.YES_OPTION)
			{
				new Hangman();
			}

			else if(loseContinuePlaying == JOptionPane.NO_OPTION)
			{
				System.exit(0);
			}
		}


		else if(message.solved())
		{
			int winContinuePlaying = JOptionPane.showConfirmDialog(null,"You win! \n Would you like to play again?", null, JOptionPane.YES_NO_OPTION);
		
			if(winContinuePlaying == JOptionPane.YES_OPTION)
			{
				new Hangman();
			}

			else if(winContinuePlaying == JOptionPane.NO_OPTION)
			{	
				System.exit(0);
			}

		}
		
	}

}

