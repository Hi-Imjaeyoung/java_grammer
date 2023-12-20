package C14Interface.BankService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankCardService extends BankExchangeService implements BankService {
    @Override
    public int withdraw(BankAccount nowAccount, int money) {
        System.out.println("인출 카드 서비스 입니다");
        if(nowAccount.getBalance().intValue()<money){
            return -1;
        }
        BigDecimal nowBalance = BigDecimal.valueOf(nowAccount.getBalance().intValue() -money);
        nowAccount.setBalance(nowBalance);
        return nowBalance.intValue();
    }

    @Override
    public int deposit(BankAccount nowAccount, int money) {
        System.out.println("입금 카드 서비스 입니다");
        BigDecimal nowBalance = BigDecimal.valueOf(nowAccount.getBalance().intValue()+money);
        nowAccount.setBalance(nowBalance);
        return nowBalance.intValue();
    }

}
