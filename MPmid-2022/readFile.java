import java.io.BufferedReader;
import java.io.FileReader;

public class readFile {
    String s = "";

    public readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                s += line;
                line = reader.readLine();
            }
        } catch (Exception e) {

        }
    }

    public String getS() {
        return s;
    }
}
