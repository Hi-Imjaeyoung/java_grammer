package C12ClassLecture;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class C1204BankAccount {
    public static void main(String[] args) {
        Account jaeyoung = new Account();
        jaeyoung.setAccountNumber("110-441");
        jaeyoung.deposit(100000000);
        jaeyoung.deposit(100000);
        System.out.println(jaeyoung.getBalance());
        jaeyoung.withdraw(100000);
        System.out.println(jaeyoung.getBalance());
        System.out.println(jaeyoung.exchangeUSD(13124)+"달러 입니다");
        System.out.println(jaeyoung.getBalance());
    }
}

class Account{
    private String accountNumber;
    private BigDecimal balance;
    static BigDecimal wonToUS = new BigDecimal(1134.4);
    // 별도의 생성자를 선언하지 않으면 깡통 생성자가 숨어있다
    // Account(){}
    // 생성자는 객체가 생성될 떄 자동으로 실행되는 메서드이다.
    Account(){
        balance = new BigDecimal(0.000);
    }
    // method Overloading
    Account(String accountNumber){
        this.accountNumber = accountNumber;
        balance = new BigDecimal(0.000);
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void deposit(long money){
        balance=(BigDecimal.valueOf(balance.intValue()+money));
    }
    public void withdraw(int money) throws IllegalArgumentException{
        if(balance.intValue()<money){
            throw new IllegalArgumentException("잔액이 읎는디요");
        }
        balance=(BigDecimal.valueOf(balance.intValue()-money));
    }
    public int getBalance(){
        return balance.intValue();
    }
    public BigDecimal exchangeUSD(int money) throws IllegalArgumentException{
        if(balance.intValue()<money){
            throw new IllegalArgumentException("잔액이 읎는디요");
        }
        balance = BigDecimal.valueOf(balance.intValue()-money);
        return BigDecimal.valueOf(money).divide(wonToUS,2, RoundingMode.HALF_UP);
    }
}
