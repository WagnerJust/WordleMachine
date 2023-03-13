import java.util.ArrayList;
import java.util.List;

public class WordBank {


    private String misplacedLetters;
    private String perfectLetters;

    private String badLetters;

    // Getters and Setters
    public String getBadLetters() {
        return badLetters;
    }

    public void setBadLetters(String badLetters) {
        this.badLetters = badLetters;
    }

    public String getMisplacedLetters() {
        return misplacedLetters;
    }

    public void setMisplacedLetters(String misplacedLetters) {
        this.misplacedLetters = misplacedLetters;
    }

    public String getPerfectLetters() {
        return perfectLetters;
    }

    public void setPerfectLetters(String perfectLetters) {
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
