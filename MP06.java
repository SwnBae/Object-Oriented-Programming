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
    private IExchangeRate[] rate;
    private int count;
    ExchangeBank(){
        count = 0;
        rate = new ExchangeCurrency[5];
    }
    void add(String name,double rate,String monetaryName) {
        if (count >= 5) {
            IExchangeRate[] new_rate = new ExchangeCurrency[count+1];
            for (int i=0;i<count+1;i++){
                if(i==count){
                    new_rate[i] = new ExchangeCurrency(name,rate,monetaryName);
                }
                else{
                new_rate[i] = this.rate[i];
                }
            }
            this.rate = new ExchangeCurrency[count+1];
            for(int i=0;i<count+1;i++){
                this.rate[i] = new_rate[i];
            }
            count++;
        } else {
            this.rate[count] = new ExchangeCurrency(name, rate, monetaryName);
            count++;
        }
    }
    void exchange(double amount){
        for(int i=0;i<count;i++){
            System.out.printf("%s : %.2f원을 환전하면 %.2f %s입니다.\n",rate[i].getName(),amount,rate[i].exchange(amount),rate[i].getMonetaryName());
        }
    }

}


public class MP06 {
    public static void main(String[] args) {
//        String[] countries = { "미국", "중국", "영국", "유로", "스위스" };
//        double[] rate = { 1335.00, 192.97, 1668.42, 1473.64, 1502.70 };
//        String[] currencyNames = { "달러", "위안", "파운드", "유로", "프랑" };

        String[] countries = { "미국", "중국", "영국", "유로", "스위스", "캐나다", "홍콩" };
        double[] rate = { 1335.00, 192.97, 1668.42, 1473.64, 1502.70, 978.95, 170.06 };
        String[] currencyNames = { "달러", "위안", "파운드", "유로", "프랑", "달러", "달러" };

        ExchangeBank bank = new ExchangeBank();
        for (int i = 0; i < countries.length; i++) {
            bank.add(countries[i], rate[i], currencyNames[i]);
        }
        bank.exchange(100000); // 10만원을 환전할 때의 금액을 나라별로 출력
    }
}
