import java.util.Scanner;

/*
Two players are required: the first one chooses a word and the second one has to guess it, by guessing letters that are part of that word.
For each letter that the second player guesses that is not part of the word, the Hangman will lose a limb.
If the Hangman loses all its body parts, the second player loses.  */

public class HangmanDriver{

	Scanner sc = new Scanner(System.in);
	Hangman game;

	public static void main(String[] args) {
		new HangmanDriver();
	}

	public HangmanDriver(){
		System.out.println("Welcome! Get a friend with you if you wanna play hangman!");
		game = new Hangman();
		System.out.println("Do you want to play again?(yes/no):");
		String again = sc.nextLine().trim().toLowerCase();
		
		while (!again.equals("no")){ //while the response is different to no

			if (again.equals("yes")){ //start new game if the response is yes
			game = new Hangman();
			System.out.println("Do you want to play again?(yes/no):");
			again = sc.nextLine().trim().toLowerCase();
			}
			else { // ask again if the response isn't yes or no
			System.out.println("I didn't understand that, type the word yes or no:");
			again = sc.nextLine().trim().toLowerCase();
			}
		}
		//when the response is no, end HangmanDriver
}
}
