
public class Word{

    private String word;
    private int id;

    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    // constructor

    public Word(String id, String word) {
        this.word = word;
        this.id = Integer.parseInt(id);
    }
}