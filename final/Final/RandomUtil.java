import java.util.Random;

public class RandomUtil {
    private Random random;

    public RandomUtil(int seed) {
        random = new Random(seed);
    }

    // lower~upper까지의 숫자 생성. lower와 upper가 포함됨
    public int randIntInRange(int lower, int upper) {
        int num = (random.nextInt(upper - lower + 1)) + lower;
        return num;
    }

    public static void main(String[] args) {
        RandomUtil ru = new RandomUtil(1000); // seed를 1000으로 지정
        for (int i = 0; i < 100; i++) {  // 숫자 100개 생성해서 출력
            // 1~6까지의 숫자들이 출력됨
            System.out.print(ru.randIntInRange(1, 6) + " ");
        }
    }
}
