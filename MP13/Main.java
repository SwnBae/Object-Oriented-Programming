import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.*;

public class Main {
    ArrayList<Double> fileRead(String filename){
        try {
            ArrayList<Double> list = new ArrayList<Double>();
            BufferedReader r = new BufferedReader(new FileReader(filename));
            String d = r.readLine();
            while (d!=null){
                String s = d.trim();
                list.add(Double.parseDouble(s));
                d = r.readLine();
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Main m1 = new Main();

        ArrayList<Double> a1 = new ArrayList<Double>();
        ArrayList<Double> a2 = new ArrayList<Double>();
        ArrayList<Double> a3 = new ArrayList<Double>();

        a1 = m1.fileRead("P07Data1.txt");
        a2 = m1.fileRead("P07Data2.txt");
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 != a1.size() && idx2!= a2.size()){
            if(a1.get(idx1)>=a2.get(idx2)){
                a3.add(a1.get(idx1));
                idx1++;
            }
            else {
                a3.add(a2.get(idx2));
                idx2++;
            }
        }
        if(idx1 == a1.size()){
            while (idx2!=a2.size()){
                a3.add(a2.get(idx2));
                idx2++;
            }
        }
        else {
            while (idx1!=a1.size()){
                a3.add(a1.get(idx1));
                idx1++;
            }
        }
        System.out.println("size: " + a3.size());
        for(double d : a3){
            System.out.println(d);
        }

    }
}