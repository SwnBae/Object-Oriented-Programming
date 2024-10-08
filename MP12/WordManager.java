import java.util.HashMap;
import java.util.Map;

public class WordManager extends WordList {
    Map<String, Integer> counts = new HashMap<String, Integer>();
    String[] nono;

    public WordManager(String sen, char[] sep, String[] no) {
        super(sen, sep);
        nono = no;
    }
    public boolean isStop(String str){
        for(String n:nono){
            if(n.equals(str)){
                return true;
            }
        }
        return false;
    }
    public boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void filter() {
        super.filter();
        for (String s :words) {
            if (!isStop(s)||!isNumber(s)) {
                if (counts.containsKey(s)) {
                    int n = counts.get(s);
                    counts.put(s, n + 1);
                } else {
                    counts.put(s, 1);
                }
            }
        }
    }

    public void getNum(int n) {
        for (String word : counts.keySet()) {
            if (counts.get(word) >= n) {
                System.out.println(word + ":" + counts.get(word));
            }
        }
    }
}
