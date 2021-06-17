import java.util.Random;

public class MakeGuesses {
    public static void main (String [] args){
        makeGuesses();

    }
    public static void makeGuesses (){
        //declaration of variables and instantiation of Random object
        int howManyGuesses = 0;
        Random guess = new Random();
        int computerGuess = guess.nextInt(50) + 1;
        boolean guessCorrect = false;
        //to do while guessCorrect is false...
        while (!guessCorrect){
            //printint out the computer's initial guess and incrementing how many guesses have been made
            System.out.println("Guess = " + computerGuess);
            howManyGuesses++;
            //if the guess is incorrect, guess a new value
            if (computerGuess < 48){
                computerGuess = guess.nextInt(50) +1;
            //if the guess is correct, print how many guesses and update the boolean to escape the while loop 
            } else {
                System.out.println("total guesses = " + howManyGuesses);
                guessCorrect = true;
            }
        }   
    }   
}
