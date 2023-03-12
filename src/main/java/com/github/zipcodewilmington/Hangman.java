package com.github.zipcodewilmington;


import java.util.Random;
import java.util.Scanner;

/**
 * @author Dean
 * @version 1.0.0
 * @date 3/10/23 21:30
 */
public class Hangman {

    public static void main(String[] args) {
        new Hangman().theGame();
    }

    public char theGame(){
        String[] wordList = new String[]{"aardvark", "wallaby", "platypus", "ostrich", "axolotl", "alligator", "elephant", "terrapin", "sidewinder"}; //list of words
        Random random = new Random();                            //new random object
        int randomWordIndex = random.nextInt(wordList.length);  //get random int based on 0 - length of index
        String theAnswer = wordList[(randomWordIndex)];         //selects the word from the wordList array using the randomly selected index value
        int answerLength = theAnswer.length();                  //gets the length of the randomly selected word
        char[] answerAsChars = new char[answerLength];          //creates char array with length of selected word - theAnswer.length()
        char[] guessesAsChars = new char[answerLength];         //store guessed chars. same length as selected word
        int numGuesses = 0;                                     //tracks total number of user guesses. will track as not to exceed theAnswer.length()
        int charIndexCounter = 0;                               //may need to make sure we add the input char to the correct index of the charArray
        char[] stringInputAsChar = new char[theAnswer.length()]; //we want to take the String input from user and convert to type char

        while(numGuesses < answerLength) {                      //setting the condition that while the user hasn't used all guesses the game will continue

            System.out.println("Let's play WordGuess version 1.0"); //introductory message
            System.out.println("Current Guesses: " + guessesAsChars); //display the guessesAsChars so user knows what they've guessed so far
            Scanner myScanner = new Scanner(System.in);             //creating new scanner object
            System.out.println("Please enter your guess: ");        //ask user for input
            stringInputAsChar = myScanner.next().charAt(0);
            //stringInputToChar = myScanner.next().toCharArray();
            //guessesAsChars[charIndexCounter] = myScanner.nextLine();
        }

        return 0;
    }



}


