import java.util.ArrayList;
import java.util.Scanner;
class ExchangeCurrency implements IExchangeRate{
    protected String name;
    protected double rate;
    protected String MonetaryName;
    ExchangeCurrency(String name,double rate,String MonetaryName){
        this.name = name;
        this.rate = rate;
        this.MonetaryName = MonetaryName;
    }
    @Override
    public double exchange(double won){
        return won/rate;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getRate() {
        return rate;
    }
    @Override
    public String getMonetaryName() {
        return MonetaryName;
    }
}
interface IExchangeRate {
    public double exchange(double won);
    public String getName();
    public double getRate();
    public String getMonetaryName();
}
class ExchangeBank {
    private ArrayList<IExchangeRate> rate;
    private int count;
    ExchangeBank(){
        count = 0;
        rate = new ArrayList<>();
    }
    void add(String name,double rate,String monetaryName) {
        this.rate.add(new ExchangeCurrency(name,rate,monetaryName));
    }
    void add(IExchangeRate exrate){
        this.rate.add(exrate);
    }
    void exchange(String name1,String name2,double amount){
        double rate1 = 0;
        double rate2 = 0;
        String mon1 = "";
        String mon2 = "";
        for(int i=0; i<rate.size();i++){
            if(name1.equals(rate.get(i).getName())){
                rate1 = rate.get(i).getRate();
                mon1 = rate.get(i).getMonetaryName();
            }
            else if(name2.equals(rate.get(i).getName())){
                rate2 = rate.get(i).getRate();
                mon2 = rate.get(i).getMonetaryName();
            }
        }

        System.out.printf("%.2f%s(%s)을 환전하면 %.2f %s(%s)입니다.\n",
        amount,mon1,name1,amount/(rate2/rate1),mon2,name2);

    }

}


public class MP07 {
    public static void main(String[] args) {
//        String[] countries = { "미국", "중국", "영국", "유로", "스위스" };
//        double[] rate = { 1335.00, 192.97, 1668.42, 1473.64, 1502.70 };
//        String[] currencyNames = { "달러", "위안", "파운드", "유로", "프랑" };

        String[] countries = { "한국","미국", "중국", "영국", "유로", "스위스", "캐나다", "홍콩" };
        double[] rate = { 1,1335.00, 192.97, 1668.42, 1473.64, 1502.70, 978.95, 170.06 };
        String[] currencyNames = { "원","달러", "위안", "파운드", "유로", "프랑", "달러", "달러" };

        ExchangeBank bank = new ExchangeBank();
        for (int i = 0; i < countries.length; i++) {
            bank.add(countries[i], rate[i], currencyNames[i]);
        }
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        double am = sc.nextInt();

        bank.exchange(s1,s2,am); // 10만원을 환전할 때의 금액을 나라별로 출력
    }
}
