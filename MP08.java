import java.util.ArrayList;

public class MP08 {

    public abstract class Account{
        private String owner;
        private int balance;
        private String number;
        private double interestRate;
        private boolean closed;
        Account(String owner,double rate){
            this.owner = owner;
            this.interestRate = rate;
            this.balance = 0;
            this.closed = false;
        }
        public int getBalance(){return balance;}
        public void setBalance(int amount){balance = amount;}

        public String getOwner() {return owner;}

        public String getAccNum() {return number;}
        public String toString(){
            String close;
            if(closed == false){close = "정상";}
            else{close = "해지";}
            return owner+" "+balance+" "+number+" "+close;}
        public void deposit(int amount){
            if(closed ==false){
                balance = balance + amount;
            }
            else{
                System.out.println("계좌가 이미 해지됨");
            }
        }
        public void withdraw(int amount){
            if(closed ==false){
                balance = balance - amount;
            }
            else{
                System.out.println("계좌가 이미 해지됨");
            }
        }
        public void close(){
            closed = true;
            System.out.printf("계좌 %s를 해지. %d원을 환급\\n",number,balance);
        }
        public abstract String generateAcctNum(int fLower,int fUpper,int sLower,int sUpper);
    }

    public class CheckingAccount extends Account{
        public CheckingAccount(String owner,double rate){
            super(owner, rate);
            super.number = generateAcctNum(101,201,10000,50000);
        }
        @Override
        public String generateAcctNum(int fLower,int fUpper,int sLower,int sUpper){
            return RandomUtil.randIntInRange(fLower,fUpper)+"-"+RandomUtil.randIntInRange(sLower,sUpper);
        }
    }
    public class SavingsAccount  extends Account{
        int monthlyPayment;
        int duration;
        int paymentCount;
        public SavingsAccount (String owner,double rate,int monthlyPayment,int duration){
            super(owner, rate);
            super.number = generateAcctNum(201,301,10000,50000);
            if(duration == 6||duration == 12){
                this.monthlyPayment = monthlyPayment;
                this.duration = duration;
                this.paymentCount = 0;
            }
        }
        @Override
        public void deposit(int amount){
            if(super.closed ==false&&monthlyPayment == amount&&paymentCount != duration){
                super.balance = super.balance + amount;
                paymentCount++;
            }
            else if(super.closed ==true){
                System.out.println("계좌가 이미 해지됨");
            }
            else if(monthlyPayment != amount){System.out.println("월납액과 입금액이 맞지 않습니다."); }
            else {System.out.println("만기됨");}
        }
        @Override
        public void withdraw(int amount){
                System.out.println("출금불가");

        }
        @Override
        public String generateAcctNum(int fLower,int fUpper,int sLower,int sUpper){
            return RandomUtil.randIntInRange(fLower,fUpper)+"-"+RandomUtil.randIntInRange(sLower,sUpper);
        }
    }
    public class BankUtil{
        public static String generateAcctNum(int fLower,int fUpper,int sLower,int sUpper){
            return RandomUtil.randIntInRange(fLower,fUpper)+"-"+RandomUtil.randIntInRange(sLower,sUpper);
        }
    }
    public class RandomUtil {
        public static int randIntInRange(int lower, int
                upper) {
            int num = ((int) (Math.random() *
                    Integer.MAX_VALUE) % (upper - lower + 1)) + lower;
            return num;
        }
    }

        public static void main(String[] args) {
            MP08 mp08 = new MP08();
            ArrayList<Account> accounts = new ArrayList<>();

            Account num1 = mp08.new CheckingAccount("cho",1.0);
            accounts.add(num1);
            Account num2 = mp08.new SavingsAccount("cho2",3.5,50000,12);
            accounts.add(num2);
            num2.deposit(50000);
            num2.deposit(5000);
            num2.withdraw(50000);
            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).owner.equals("cho")){
                    System.out.println(num2);
                }
            }
            accounts.remove(0);
            accounts.get(0).deposit(100);
            System.out.println(accounts.get(0));
        }

}
