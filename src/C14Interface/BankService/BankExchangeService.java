package C14Interface.BankService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankExchangeService {
    static BigDecimal wonToUS = new BigDecimal(1134.4);

    public  BigDecimal exchangeUSD(BankAccount nowAccount, int money) {
        System.out.println("달러 환전 서비스 입니다.");
        if(nowAccount.getBalance().intValue()<money){
            return BigDecimal.valueOf(-1);
        }
        BigDecimal nowBalance = BigDecimal.valueOf(nowAccount.getBalance().intValue() -money);
        nowAccount.setBalance(nowBalance);
        return BigDecimal.valueOf(money).divide(wonToUS,2, RoundingMode.HALF_UP);
    }
}
