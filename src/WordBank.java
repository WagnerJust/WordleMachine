import java.util.ArrayList;
import java.util.List;

public class WordBank{


    private List<Word> wordBank;
    private List<Word> possibleWords;
    private List<Character> badLetters;
    private List<Character> goodLetters;

//getters and setters
    public List<Word> getWordBank() {
        return wordBank;
    }

    public void setWordBank(List<Word> wordBank) {
        this.wordBank = wordBank;
    }

    public List<Word> getPossibleWords() {
        return possibleWords;
    }

    public void setPossibleWords(List<Word> possibleWords) {
        this.possibleWords = possibleWords;
    }

    public List<Character> getBadLetters() {
        return badLetters;
    }

    public void setBadLetters(List<Character> badLetters) {
        this.badLetters = badLetters;
    }

    public List<Character> getGoodLetters() {
        return goodLetters;
    }

    public void setGoodLetters(List<Character> goodLetters) {
        this.goodLetters = goodLetters;
    }


    //constructor

    public WordBank(List<Word> wordBank) {
        this.wordBank = wordBank;
        this.badLetters = new ArrayList<>();
        this.goodLetters = new ArrayList<>();
    }



}