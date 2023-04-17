package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    //main method to run the game
    public static void main(String[] args) {
        //create new Hangman object and call theGame method
        new Hangman().theGame();
    }

    //method to play the game
    public void theGame() {
        //array of words to be guessed
        String[] wordList = new String[]{"aardvark", "wallaby", "platypus", "ostrich", "axolotl", "alligator", "elephant", "terrapin", "sidewinder"};
        //create a new Random object
        Random random = new Random();
        //choose a random index from the wordList array
        int randomWordIndex = random.nextInt(wordList.length);
        //select the word at the random index
        String theAnswer = wordList[randomWordIndex];
        //create a StringBuilder object with the same length as theAnswer filled with underscores
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < theAnswer.length(); i++) {
            sb.append("_");
        }

        //create new array to store user guesses
        char[] userGuesses = new char[theAnswer.length()];
        //initialize the number of guesses made to 0
        int numGuesses = 0;

        //print initial message to user
        System.out.println("Let's play WordGuess version 1.0");
        Scanner myScanner = new Scanner(System.in);

        while (numGuesses < 7) {
            System.out.println("Current word: " + sb); //print current state of word
            System.out.println("Current guesses: " + Arrays.toString(userGuesses)); //print user's current guesses
            System.out.println("You have " + (7 - numGuesses) + " tries left."); //print number of tries user has left
            System.out.println("Please enter a letter: "); //ask for user to enter a char
            String input = myScanner.next(); //gets user's input
            if (input.length() != 1) { //if user entered anything besides a single char then give warning
                System.out.println("Please enter a single character.");
                continue; //skip to next iteration of loop
            }
            char userGuess = input.charAt(0);
            if (theAnswer.contains(String.valueOf(userGuess))) {
                for (int i = 0; i < theAnswer.length(); i++) {
                    if (theAnswer.charAt(i) == userGuess) {
                        sb.setCharAt(i, userGuess);
                    }
                }
            } else {
                System.out.println("Sorry, that letter is not in the word.");
                numGuesses++;
            }
            userGuesses[numGuesses] = userGuess;
            if (sb.toString().equals(theAnswer)) {
                System.out.println("Winner");
                return;
            }
        }
        System.out.println("You feel the noose tighten around your neck and you slowly fade into black.: " + theAnswer);
    }
}

