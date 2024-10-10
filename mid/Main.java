class LicensePlate{
    //201910899 배수한 아따맘마
    private String number;
    private boolean parseError;
    private int firstNum;
    private int secondNum;
    private char hangul;
    private char[] hangulArray;
    public LicensePlate(char[] hangulArray){
        this.hangulArray = hangulArray;
        this.number = null;
        this.parseError = false;
    }

    public void setNumber(String number) {
        this.number = number;
        this.secondNum = getSecondNumber(number.length());
        this.firstNum = getFirstNumber();

    }

    public boolean getParseError(){
        return parseNumber();
    }
    public void printInfo(){
        if(getParseError()==true) {
            if (firstNum >= 100 && firstNum <= 699) {
                System.out.println("승용차");
            } else if (firstNum >= 700 && firstNum <= 799) {
                System.out.println("승합차");
            } else if (firstNum >= 800 && firstNum <= 979) {
                System.out.println("화물차");
            } else if (firstNum >= 980 && firstNum <= 998) {
                System.out.println("특수차");
            } else if (firstNum >= 998 && firstNum <= 999) {
                System.out.println("긴급자동차");
            } else if (firstNum >= 100 && firstNum <= 699) {
                System.out.println("승용차");
            }
            if (hangul == '바'||hangul=='사'||hangul=='아'||hangul=='자'){
                System.out.println(" 사업용(운수)");
            }
            else if (hangul == '하'||hangul=='허'||hangul=='호'){
                System.out.println(" 사업용(렌터/리스)");
            }
            else if (hangul == '배'){
                System.out.println(" 사업용(택배)");
            }
            else {
                System.out.println("자가용");
            }
        }

    }
    public boolean parseNumber(){
        if(number.charAt(5) !=' '){
            System.out.println("오류: 앞번호와 뒷번호 사이에 공백이 없습니다.");
            parseError = false;
            return false;
        } else if (getFirstNumber()==-1||getSecondNumber()==-1) {
            System.out.println("자동차 번호가 지정되지 않았습니다.");
            parseError = false;
            return false;
        }
        parseError = true;
        return true;
    }

    private int getSecondNumber(int idx){
        if(this.number.length()>9){
            System.out.println("오류: 뒷번호의 길이가 너무 길거나 짧습니다.");
            return -1;
        } else if (NumString.isDigit(number.charAt(5)+number.charAt(6)+number.charAt(7)+number.charAt(8)+"")==false) {
            System.out.println("오류: 뒷번호가 숫자가 아닙니다.");
            return -1;
        } else if(Integer.parseInt(number.charAt(5)+number.charAt(6)+number.charAt(7)+number.charAt(8)+"")<100){
            System.out.println("오류: 뒷번호가 100 미만입니다.");
            return -1;
        }
        else{
            return Integer.parseInt(number.charAt(5)+number.charAt(6)+number.charAt(7)+number.charAt(8)+"");
        }

    }
    private int getFirstNumber(){
        if (NumString.isDigit(number.charAt(0)+number.charAt(1)+number.charAt(2)+"")==false) {
            System.out.println("오류: 앞번호가 숫자가 아닙니다.");
            return -1;
        } else if(Integer.parseInt(number.charAt(0)+number.charAt(1)+number.charAt(2)+"")<100){
            System.out.println("오류: 앞번호가 100 미만입니다.");
            return -1;
        }
        else{
            return Integer.parseInt(number.charAt(0)+number.charAt(1)+number.charAt(2)+"");
        }
    }
}


class NumString {
    public static boolean isDigit(String num) {
        if (num == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(num);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
//201910899 배수한 아따맘마
public class Main {
    public static void main(String[] args) {
        char[] hangulArr = { '가', '나', '다', '라', '마',
            '거', '너', '더', '러', '머', '버', '서', '어', '저',
            '고', '노', '도', '로', '모', '보', '소', '오', '조',
            '구', '누', '두', '루', '무', '수', '우', '주', '바',
            '사', '아', '자', '배', '하', '허', '호' };

        String[] nums = { "100가 11111", "1가  1111", "000가 1111",
        "000가 1111", "100 가1111", "100가1111 ", "100가 0011",
        "150히 1111", "01가 1111", "200하 1111", "150배 1111",
                "150누 1111"};

        LicensePlate plate = new LicensePlate(hangulArr);
        for (String n : nums) {
            System.out.println("\n" + n);
            plate.setNumber(n);
            if (plate.getParseError() == false) {
                plate.printInfo();
            }
        }
    }
}
