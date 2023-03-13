import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleMachine {
    private WordBank wordBank = null;
    private String userWord;
    private List<Word> possibleWords = new ArrayList<>();



 //getters and settters

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

    public List<Word> possibleWords(String word) {
        for(Word bankWord: wordBank.getWordsInBank()){
            filterThroughCharacters(bankWord);
        }
        return possibleWords;
    }

    public void filterThroughCharacters(Word wordToCheck){
        for(char i : wordBank.getBadLetters().toCharArray()){
            if(wordToCheck.getWord().indexOf(i) == -1){
                wordToCheck.setPossible(false);
            }
        }
        for(char i : wordBank.getPerfectLetters().toCharArray()){
            if(wordToCheck.getWord().indexOf(i) != -1 && wordToCheck.isPossible){
                possibleWords.add(wordToCheck);
            }
        }
        for(char i : wordBank.getMisplacedLetters().toCharArray()){
            if(wordToCheck.getWord().indexOf(i) != -1 && wordToCheck.isPossible){
                possibleWords.add(wordToCheck);
            }
        }
    }


    public WordleMachine() throws FileNotFoundException {
        readBank();
    }


}
