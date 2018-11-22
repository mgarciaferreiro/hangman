import java.util.Scanner;

public class Hangman{
//variables
    String word;
    int bodyparts;
    String guess;
    char letter;
    StringBuffer dashes;
    boolean finished;
    String guesses;
	Scanner sc = new Scanner(System.in);

	public Hangman() {

    System.out.println("Player #1, choose a word that your friend will try to guess (don't be a bad friend and choose a number): ");
    word = sc.nextLine().trim().toLowerCase();
    String body[]= new String[16];
    body[0] = ("                    ");
    body[1] = ("00000000000000      ");
    body[2] = ("0           0       ");
    body[3] = ("0           1       ");
    body[4] = ("0          1 1      ");
    body[5] = ("0           1       ");
    body[6] = ("0          324      ");
    body[7] = ("0         3 2 4     ");
    body[8] = ("0        3  2  4    ");
    body[9] = ("0          5 6      ");
    body[10] =("0         5   6     ");
    body[11] =("0        5     6    ");
    body[12] =("0       5       6   ");
    body[13] =("0                   ");
    body[14] =("0                   ");
    body[15] =("0                   ");

    for (int i=0; i<=15; i++){ //print original body
        System.out.println(body[i]);
    }
    for (int i=0; i<4; i++){ //print empty lines so player 2 can't see the word
        System.out.println("");
    }

    System.out.println("The game is going to start!");

    finished = false;
    dashes = makeDashes(word);
    bodyparts = 6;
    guesses = "";


	while (!finished){ //run while finished is false 

    System.out.println("This is your word: " + dashes);
    System.out.println("These are your guesses so far: "+ guesses);
    System.out.println("Player #2, make a guess (letter or word): ");
    String guess = sc.next().trim().toLowerCase();
     
     if(guess.length()> 1){ //if the guess is a word
        if (guess.equals(word)){
            System.out.println("That's the right word! You won!");
            finished = true;
        }
        else {
            System.out.println("That's not the right word.");
            finished = true;
        }
     }
     else {  // if the guess is a letter
        letter = guess.charAt(0);
        guesses += letter;
        if(word.indexOf(letter) < 0){ //if the letter is not in word
            bodyparts--;
            System.out.println("Bad guess. ");
        }
        else { //if the letter is in the word
            matchLetter(word, dashes, letter);
        }
        System.out.println(bodyparts + " body parts are left.");
        System.out.println("");
/*the body will be drawn with the missing body parts
  The numbers that make it will be replaced by spaces in each string of the array
  */
        if (bodyparts==6){
            for (int i=0; i<=15; i++){
            System.out.println(body[i]);
            }}
        else if (bodyparts==5){
            for (int i=0; i<=15; i++){
            String body2 = body[i].replace("6"," ");
            System.out.println(body2);
            }}
        else if (bodyparts==4){
            for (int i=0; i<=15; i++){
            String body3 = body[i].replace("6"," ").replace("5"," ");
            System.out.println(body3);
            }}
        else if (bodyparts==3){
            for (int i=0; i<=15; i++){
            String body4 = body[i].replace("6"," ").replace("5"," ").replace("4"," ");
            System.out.println(body4);
            }}
        else if (bodyparts==2){
            for (int i=0; i<=15; i++){
            String body5 = body[i].replace("6"," ").replace("5"," ").replace("4"," ").replace("3"," ");
            System.out.println(body5);
            }}
        else if (bodyparts==1){
            for (int i=0; i<=15; i++){
            String body6 = body[i].replace("6"," ").replace("5"," ").replace("4"," ").replace("3"," ").replace("2"," ");
            System.out.println(body6);
            }
        }
        else{
            System.out.println("You lost. ");
            for (int i=0; i<=15; i++){
            String body7 = body[i].replace("6"," ").replace("5"," ").replace("4"," ").replace("3"," ").replace("2"," ").replace("1"," ");
            System.out.println(body7);
            }
            finished = true;
        }
        if (word.equals(dashes.toString())){
            System.out.println("This is your word: " + dashes);
            System.out.println("You won! ");
            finished = true;
        }

    }
}
}
/* This method substitutes each dash for the letter that has been guessed
   The letter is substituted into the position of the corresponding dash
   Each position must be checked to see if it's the same as the letter
   */
    public void matchLetter(String word, StringBuffer dashes, char letter){

        for (int i=0; i<word.length(); i++){
        if (word.charAt(i) == letter){
            System.out.println("That was a good guess! ");
            dashes.setCharAt(i,letter);
            }
    }
}
/* This method creates the dashes, which are a string that can be modified
    */
    public static StringBuffer makeDashes(String s){

         StringBuffer dashes = new StringBuffer(s.length());
         for (int i=0; i< s.length(); i++){
            dashes.append('-');
        }
         return dashes;
      }
} //end of Hangman
