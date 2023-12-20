package C14Interface.BankService;

import java.math.BigDecimal;

public class BankKapayService implements BankService {
    @Override
    public int withdraw(BankAccount nowAccount, int money) {
        System.out.println("인출 카카오 서비스 입니다");
        if(nowAccount.getBalance().intValue()<money){
            System.out.println("잔액이 부족합니다");
            return -1;
        }
        BigDecimal nowBalance = BigDecimal.valueOf(nowAccount.getBalance().intValue() -money);
        nowAccount.setBalance(nowBalance);
        return nowBalance.intValue();
    }

    @Override
    public int deposit(BankAccount nowAccount, int money) {
        System.out.println("입금 카카오 서비스 입니다");
        BigDecimal nowBalance = BigDecimal.valueOf(nowAccount.getBalance().intValue()+money);
        nowAccount.setBalance(nowBalance);
        return nowBalance.intValue();
    }
}
