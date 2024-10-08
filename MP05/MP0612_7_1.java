import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
public class MP0612_7_1 {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new FileInputStream("circle.txt"));
            double r = sc.nextDouble();
            System.out.println(r);
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재x");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
