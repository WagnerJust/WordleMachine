import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleMachine{

    private WordBank wordbank;


//getters and setters
    public WordBank getWordbank() {
        return wordbank;
    }

    public void setWordbank(WordBank wordbank) {
        this.wordbank = wordbank;
    }

    //constructor
    public WordleMachine(WordBank wordbank) {
        this.wordbank = wordbank;
    }
    public WordleMachine() throws FileNotFoundException {
        fillWordBank();
    }

    public void fillWordBank() throws FileNotFoundException {
        File wordFile = new File("5_letter_words.csv");
        Scanner wordReader = new Scanner(wordFile);
        List<Word> holder = new ArrayList<>();
        while(wordReader.hasNextLine()){
            String fileContents = wordReader.nextLine();
            String[] splitData = fileContents.split(",");
            holder.add(new Word(splitData[0], splitData[1]));
        }
        wordbank = new WordBank(holder);

    }

    public void updateGoodLetters (Character c){
        List<Character> holder = wordbank.getGoodLetters();
        holder.add(c);
        wordbank.setGoodLetters(holder);
        System.out.println("updated good letters with letter " + c + "\n");

    }

    public void updateBadLetters (Character c){
        List<Character> holder = wordbank.getBadLetters();
        holder.add(c);
        wordbank.setBadLetters(holder);
        System.out.println("updated bad letters");
    }


    public void filterWords(List<Character> bad, List<Character> good){
        List<Word> holder = new ArrayList<>();
        for(Word wordFromBank : wordbank.getWordBank()){
            for(Character bLetter : bad){
                if (!wordFromBank.getWord().contains(bLetter.toString())) {
                    for(Character gLetter : good){
                        if(wordFromBank.getWord().contains(gLetter.toString())){
                            holder.add(wordFromBank);
                        }
                    }
                }
            }
        }
        wordbank.setPossibleWords(holder);
    }


}