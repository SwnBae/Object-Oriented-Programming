import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MP09 {
    public static void main(String[] agrs){
        String s = "";
        ArrayList<Word> words = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("mp.txt"));
            while (sc.hasNext()){
                s += sc.nextLine();
            }

            System.out.println((s));
            String[] arr = s.split("[\t\n :.,;-]");
            boolean find = false;
            for(int i=0;i< arr.length;i++){
                find = false;
                if (i == 0) {
                    words.add(new Word(arr[0]));
                }
                else{
                    for(int j=0;j< words.size();j++){
                        if(arr[i].equals(words.get(j).getWord())){
                            words.get(j).upNum();
                            find = true;
                            break;
                        }
                    }
                    if(find == false){
                        words.add(new Word(arr[i]));
                    }
                }
            }
            for(int i=0;i< words.size();i++){
                System.out.println(words.get(i));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
