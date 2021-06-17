import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
    public static void main (String[] args){
        guessTester();
    }
    public static void guessTester(){
        
        //declaration/instantiation of variables 
        boolean guess = false;
        int howManyGuesses = 0;
        int minNum = 1;
        int maxNum = 10;
        int computersGuess;

        //creating the scanner class and random class
        Scanner console = new Scanner (System.in);
        Random randNum = new Random();

        //enter this loop because guess == false
        while (!guess){
            
            //this will choose a peusdorandom number between 1 and 10
            computersGuess = Math.abs(randNum.nextInt()) % (maxNum - minNum) + minNum;
            
            //printing out the guess, prompting the user for input, incrementing how many guesses, and moving to the next line
            System.out.print("Is it " + computersGuess + "?(y/n) ");
            howManyGuesses++;
            String input = console.nextLine();
            
            //testing the users input if it is n or y
            if (input.charAt(0) == 'n'){
                if(minNum >= computersGuess){
                    minNum = computersGuess +1;

                } else {
                    maxNum = computersGuess - 1;
                }
                } else if (input.charAt(0)== 'y') {
                   //setting the boolean to true to escape the while loop if the user indicates that the value they were thinking of has been guessed
                    guess = true;
                    System.out.println("I got your number of " + computersGuess + " in " + howManyGuesses + " guesses.");
                }
            }
            console.close();

        }
    }