//201910899 배수한 아따맘마
public class Main {
    public static void main(String[] args) {
        CircularArray array = new CircularArray(1000, 20, 0, 10);
        FileEncoder encoder = new FileEncoder(array);
        encoder.encodeFile("Final2Data.txt", "Encoded_Final2Data.txt");
        encoder.decodeFile("Encoded_Final2Data.txt", "Decoded_Final2Data.txt");
    }
}
