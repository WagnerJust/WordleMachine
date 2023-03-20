import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleMachine {
    private WordBank wordBank = null;
    private String userWord;
    private List<Word> possibleWords = new ArrayList<>();



 //getters and setters


    public WordBank getWordBank() {
         return wordBank;
    }
    public void setWordBank(WordBank wordBank){
        this.wordBank = wordBank;
    }

    public String getUserWord() {
        return userWord;
    }

    public void setUserWord(String userWord) {
        this.userWord = userWord;
    }

    public List<Word> getPossibleWords() {
        return possibleWords;
    }

    public void setPossibleWords(List<Word> possibleWords) {
        this.possibleWords = possibleWords;
    }

    public void readBank() throws FileNotFoundException {
        File inputFile = new File("5_letter_words.csv");
        Scanner fileReader = new Scanner(inputFile);
        List<Word> startingWordBank = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            String filePath = fileReader.nextLine();
            String[] splitData = filePath.split(",");
            startingWordBank.add(new Word(splitData[0], splitData[1]));
        }
        wordBank = new WordBank(startingWordBank);
    }


    public void filterWords() {
        for (Word wordFromBank : wordBank.getWordsInBank()) {  // grab a wordbank word
            for (String letter : wordBank.getBadLetters()) { // loop through bad letters and check if wordbank word has them
                if (wordFromBank.getWord().contains(letter)) {
                    wordFromBank.setPossible(false);
                }
            }
            for (String letter : wordBank.getMisplacedLetters()) {
                if (!wordFromBank.getWord().contains(letter)) {
                    wordFromBank.setPossible(false);
                }
            }
            for (String letter : wordBank.getPerfectLetters()) {
                if (!wordFromBank.getWord().contains(letter)) {
                    wordFromBank.setPossible(false);
                }
            }
            if(wordFromBank.isPossible){
                possibleWords.add(wordFromBank);
            }
        }
        this.setPossibleWords(possibleWords);
    }



    public WordleMachine() throws FileNotFoundException {
        readBank();
        this.possibleWords = wordBank.getWordsInBank();

    }


}
