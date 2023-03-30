import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class WordleCLI {


    public void run() throws FileNotFoundException {
        WordleMachine myMachine = new WordleMachine();


        boolean isRunning = true;
        while(isRunning) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter good letters separated by comma: ");

            Scanner letterReader = new Scanner(userInput.nextLine());

            letterReader.useDelimiter(",");
            while (letterReader.hasNext()) {
                myMachine.updateGoodLetters(letterReader.next().charAt(0));
            }

            System.out.println("Enter bad letters seperated by comma: ");
            letterReader = new Scanner(userInput.nextLine());
            while (letterReader.hasNext()) {
                myMachine.updateBadLetters(letterReader.next().charAt(0));
            }

            myMachine.filterWords(myMachine.getWordbank().getBadLetters(), myMachine.getWordbank().getGoodLetters());


            printPossibleList(myMachine);

            System.out.println("\nTo exit, enter 0. To continue, type any other number");
            if(userInput.next().equals("0")){
                System.out.println("Thanks for trying my application");
                System.exit(0);
            } else continue;

        }

        System.out.println("Thanks for trying my application!");
    }

    public static void main (String[]args) throws IOException {
        WordleCLI cli = new WordleCLI();
        cli.run();

    }

    public static void printPossibleList(WordleMachine myMachine){

        int i = 0;
        for(Word word : myMachine.getWordbank().getPossibleWords()){
            System.out.print(word.getWord() + "\t");
            i++;
            if(i%8 == 0){
                System.out.println();
            }
        }
    }

}