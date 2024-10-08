import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("S",1);
        map.put("A",1);
        map.put("B",1);
        map.put("C",1);
        map.put("D",1);

        System.out.println(map);

        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            int count = map.get(key);
            System.out.println(key+":"+count);
        }
        for (String s:map.keySet()){
            System.out.printf("%s : %d\n",s,map.get(s));
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.printf("%s : %d\n",entry.getKey(),entry.getValue());
        }


        /*
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("S");
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");

        System.out.println(arr);

        Iterator it = arr.iterator();
        while (it.hasNext()){
            String s = (String) it.next();
            System.out.println(s);
        }

        for(String s:arr){
            System.out.println(s);
        }
*/


    }
}