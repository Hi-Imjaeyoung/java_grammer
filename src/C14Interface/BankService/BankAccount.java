package C14Interface.BankService;

import java.math.BigDecimal;

public class BankAccount {
        private String accountNumber;
        private BigDecimal balance;
        static BigDecimal wonToUS = new BigDecimal(1134.4);
        // 별도의 생성자를 선언하지 않으면 깡통 생성자가 숨어있다
        // Account(){}
        // 생성자는 객체가 생성될 떄 자동으로 실행되는 메서드이다.
        // method Overloading
        BankAccount(String accountNumber) {
            this.accountNumber = accountNumber;
            balance = new BigDecimal(0.000);
        }
    public String getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal getBalance(){
        return balance;
    }
    public void setBalance(BigDecimal input){
        this.balance = input;
    }
}
