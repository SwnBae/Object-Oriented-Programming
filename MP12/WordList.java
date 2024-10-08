import java.util.ArrayList;

public class WordList {
    protected ArrayList<String> words = new ArrayList<String>();
    private String sen;
    private char sep[];

    public WordList(String s, char[] sep) {
        this.sen = s;
        this.sep = sep;
    }

    public void filter() {
        String s = "";
        boolean br = false;
        for (int i = 0; i < sen.length(); i++) {
            for (int j = 0; j < sep.length; j++) {
                if (sep[j] == sen.charAt(i)) {
                    br = true;
                }
            }
            if (br != true) {
                s += sen.charAt(i);
            } else {
                words.add(s);
                br = false;
                s = "";
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < words.size(); i++) {
            s += words.get(i) + " ";
        }
        return s;
    }
}
