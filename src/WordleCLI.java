import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleCLI {

    public void run() throws FileNotFoundException {


        WordleMachine myMachine = new WordleMachine();
        welcomeStatement();
        explanationStatement();


        promptUser();
        Scanner userInput = new Scanner(System.in);
        Scanner wordScanner = new Scanner(userInput.nextLine());
        wordScanner.useDelimiter(",");

        myMachine.setUserWord(wordScanner.next());
        myMachine.getWordBank().setPerfectLetters(wordScanner.next().trim());
        myMachine.getWordBank().setMisplacedLetters(wordScanner.next().trim());
        myMachine.getWordBank().setBadLetters(wordScanner.next().trim());


        printPossibleList(myMachine);



    }



    public static void main (String[]args) throws IOException {
        WordleCLI cli = new WordleCLI();
        cli.run();
    }

    public static void welcomeStatement(){
        System.out.println("\n\n-----------------------------------");
        System.out.println("     Welcome to Wordle Machine     ");
        System.out.println("-----------------------------------");
        System.out.println();
    }

    public static void explanationStatement(){
        System.out.println("     HOW DOES IT WORK?     ");
        System.out.println();
        System.out.println("Wordle Machine is a program that helps you solve the Wordle!" +
                "It does this in a couple steps:\n");
    }


    public static void promptUser(){
        System.out.println("-------DO THE FOLLOWING SEPARATED BY COMMAS | NO SPACES ------");
        System.out.println("\nPlease enter your word, perfect letters, misplaced letters, and bad letters:\n");
    }

    public static void printPossibleList(WordleMachine myMachine){

      List<Word> listPossibleWords = myMachine.possibleWords(myMachine.getUserWord());
      int i = 0;
      for(Word word : listPossibleWords){
          System.out.print(word.getWord() + "\t");
          i++;
          if(i%4 == 0){
              System.out.println();
          }
      }
    }
}
