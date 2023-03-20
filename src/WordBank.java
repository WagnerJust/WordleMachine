import java.util.ArrayList;
import java.util.List;

public class WordBank {


    private List<String> misplacedLetters;
    private List<String> perfectLetters;

    private List<String> badLetters;

    // Getters and Setters
    public List<String> getBadLetters() {
        return badLetters;
    }

    public void setBadLetters(List<String> badLetters) {
        this.badLetters = badLetters;
    }

    public List<String> getMisplacedLetters() {
        return misplacedLetters;
    }

    public void setMisplacedLetters(List<String> misplacedLetters) {
        this.misplacedLetters = misplacedLetters;
    }

    public List<String> getPerfectLetters() {
        return perfectLetters;
    }

    public void setPerfectLetters(List<String> perfectLetters) {
        this.perfectLetters = perfectLetters;
    }


    // Methods
    public List<Word> getWordsInBank() {
        return wordsInBank;
    }

    public void setWordsInBank(List<Word> wordsInBank) {
        this.wordsInBank = wordsInBank;
    }

    private List<Word> wordsInBank = new ArrayList<>();


    public WordBank(List<Word> startingWordBank){
        this.wordsInBank = startingWordBank;
    }




}
