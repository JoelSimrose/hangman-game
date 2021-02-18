//Joel Simrose
//Message Class
//September 25th, 2018

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.util.Arrays;


/**
*This is a class which contains information about the secret word to guess
*/
public class Message
{

	int messageComplete = 0;			//variable to keep track of how many letters are have been found
 	String currentWord = null;			//create string to hold the current word 
	char[] hiddenWord = new char[20];	//create hidden word char array
	
	/**
	*This is the message constructor 
	*/
	public Message()
	{
		currentWord = initArray();					//keep track of the random word chosen
		hiddenWord = initBlankArray(currentWord);	//initialize hidden word with values
		currentWord = currentWord.toLowerCase();	//make current word case insensitive for checking
	}


	/**
	*This is a method which is used to check if a guess is correct or not 
	*@param guess takes a character which the user has inputted in order to compare to the current word
	*@return will return true if the user guessed a correct letter or false if the user has guessed an incorrect letter
	*/
	public boolean guess(char guess)
	{
		boolean foundLetter = false;		//boolean to check if a letter has been found

		for(int i=0; i < currentWord.length(); i++)		//compare all values of the current word and the character chosen 
		{
			if(guess == currentWord.charAt(i))
			{
				hiddenWord[i] = currentWord.charAt(i);	//if there has been a match then uncover hidden letter and assign the current character to it
				foundLetter = true;
			}
		}

		if(foundLetter)	
		{
			return true;
		}

		else
		{
			return false;
		}
	
	}


	/**
	*This is a method which checks whether the user has won hangman or not
	*@return boolean returns true if all letters in the hidden array have been uncovered and are the same as the current word or false if 
	*not all correct letters have been guessed
	*/
	public boolean solved()
	{
		for(int i=0; i < currentWord.length(); i++)		//go through hidden word and current word and compare values
		{
			if(hiddenWord[i] == currentWord.charAt(i))	//if letters in current word and hidden word match then increment messageComplete
			{
				messageComplete++;
			}	
		}

		if(messageComplete == currentWord.length())		//if the number of matched letters is equal to the size of the current word then return true 
		{
			messageComplete = 0;
			return true;
		}

		else
		{
			messageComplete = 0;
			return false;
		}
		
	}


	/**
	*This is a method which takes in a character array and copies it into a string for output to the JOptionPane
	*@param array takes a character array which it copies into a string
	*@return returns the current hidden character string
	*/
	public String toString(char[] array)
	{
		String arrayString = new String(array);				//copy char into a string
		arrayString = arrayString.replace("", " ").trim();	//add spacing between hidden letters
		return arrayString;								
	}

	/**
	*This is a method which is used to create an array of animals, chose an animal at random, and return the current chosen word
	*@return returns the current randomly chosen word
	*/
	public String initArray()
	{
		int randomNumber = RandomArrayGen();	//get a random number between 1 and 20

		String[] wordArray = {"Cat", "Dog", "Elephant", "Lion", "Ostrich", 
		"Monkey", "Chinchilla","Alligator","Zebra", "Tiger", "Parrot", "Ocelot"
		,"Panda", "Orangutan","Bear", "Peacock", "Turtle", "Lizard", "Snake", "Otter"};

		String currentWord = wordArray[randomNumber];	//assign the array value randomly chosen to the current word 

		return currentWord;

	}

	/**
	*This is a method which is used to create a hidden character letter array. All letters from the current word are replaced with dashes
	*@param currentWord passes in the current word in order to determine the size of array of dashes to make
	*@return returns the character array of dashes  
	*/
	public char[] initBlankArray(String currentWord)
	{
		char[] temp = new char[currentWord.length()];	//create a char array for the size of the current word and fill with dashes

		for(int i=0; i < currentWord.length(); i++)
		{
			temp[i] = '_';
		}

		return temp;

	}

	/**
	*This is a method which gets gets a random number between 1 and 20 which is used to choose the current word
	*@return returns the random number which was chosen
	*/
	public int RandomArrayGen()
	{

		Random number = new Random();		//get a random number between 1 and 20
		int randNum = number.nextInt(20); 

		return randNum;

	}

	/**
	*This is a method which is used to convert the hiddenWord character array into a string
	*@param hiddenWord to pass in the hidden word char array
	*@return returns the new string which was made using toString to output to the JOptionPane
	*/
	public String show(char[] hiddenWord)
	{
		String returnValue = toString(hiddenWord);	//pass char array into toString() in order to output in a JOptionPane
		return returnValue;
	}
}

