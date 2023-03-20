import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        try {
            myMachine.getWordBank().setPerfectLetters(Arrays.asList(wordScanner.next().trim().split("")));
            myMachine.getWordBank().setMisplacedLetters(Arrays.asList(wordScanner.next().trim().split("")));
            myMachine.getWordBank().setBadLetters(Arrays.asList(wordScanner.next().trim().split("")));
        } catch (Exception e){
            System.out.printf(e.getMessage());
        }
        printPossibleList(myMachine);

        boolean isTrue = true;
        while(isTrue){
            userExit();
            if(userInput.nextLine().equals("0")){
                System.out.println("Now exiting the machine. Thank you for trying out my code!");
                isTrue = false;
            }
            promptUser();
            wordScanner = new Scanner(userInput.nextLine());
            wordScanner.useDelimiter(",");

            myMachine.setUserWord(wordScanner.next());

            //Update Lists of perfect, misplaced, and bad letters
            List<String> updatePerfectLetters =  Arrays.asList(wordScanner.next().trim().split(""));

            myMachine.getWordBank().setPerfectLetters(Stream.concat(myMachine.getWordBank().getPerfectLetters().stream(),updatePerfectLetters.stream()).collect(Collectors.toList()));

            List<String> updateMisplacedLetters =  Arrays.asList(wordScanner.next().trim().split(""));
            myMachine.getWordBank().setMisplacedLetters(Stream.concat(myMachine.getWordBank().getMisplacedLetters().stream(),updateMisplacedLetters.stream()).collect(Collectors.toList()));

            List<String> updateBadLetters =  Arrays.asList(wordScanner.next().trim().split(""));
            myMachine.getWordBank().setBadLetters(Stream.concat(myMachine.getWordBank().getMisplacedLetters().stream(), updateBadLetters.stream()).collect(Collectors.toList()));

            printPossibleList(myMachine);
        }
        System.exit(0);



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
        System.out.println("\n-------DO THE FOLLOWING SEPARATED BY COMMAS | NO SPACES ------");
        System.out.println("\nPlease enter your word, perfect letters, misplaced letters, and bad letters:\n");
    }
    public static void userExit(){
        System.out.println();
        System.out.println("\tIf you wish to stop, please enter 0\n");
    }

    public static void printPossibleList(WordleMachine myMachine){

      myMachine.filterWords();
      int i = 0;
      for(Word word : myMachine.getPossibleWords()){
          System.out.print(word.getWord() + "\t");
          i++;
          if(i%4 == 0){
              System.out.println();
          }
      }
    }
}
