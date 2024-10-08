public class Word {
    String word;
    int num;
    Word(String word) {
        num = 1;
        this.word = word;
    }
    public int getNum() {
        return num;
    }
    public String getWord() {
        return word;
    }
    public void upNum() {
        num++;
    }

    @Override
    public String toString() {
        return word + " :" +num;
    }
}
