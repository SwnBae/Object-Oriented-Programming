public class CircularArray {
    private RandomUtil ru;
    // 3.1 나머지 멤버 변수 선언
    private int size;
    private int[] circulararr;
    private int count = 0;
    public CircularArray(int seed, int size, int minv, int maxv) {
        ru = new RandomUtil(seed);
        // 나머지 코드 작성
        this.size = size;
        circulararr = new int[size];
        for(int i=0;i<size;i++){
            circulararr[i] = ru.randIntInRange(minv,maxv);
        }
    }

    // 3.2
    public int next() {
        // 코드 작성
        if(count>=size){
            count = (count+1)%size;
        }
        else {
            count++;
        }
        return circulararr[count-1];
    }

    // 3.3
    public void reset() {
        // 코드 작성
        count = 0;
    }

    public void print() {
        System.out.print("CircularArray's array: ");
        // 나머지 코드 작성
        for(int i:circulararr){
            System.out.printf("%d, ",i);
        }
    }

    // CircularArray 테스트 코드
    // 출력 결과 10 9 7 2 7 10 9 7 2 7
    public static void main(String[] args) {
        CircularArray arr = new CircularArray(1000, 5, 0, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr.next() + ", ");
        }
        System.out.println("");
    }
}
