public class Word {

    private String word;
    private String wordId;
    boolean isPossible;

    public void setPossible(boolean possible) {
        isPossible = possible;
    }



    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public Word(String id, String word){
        this.wordId=id;
        this.word = word;
        this.isPossible = true;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
