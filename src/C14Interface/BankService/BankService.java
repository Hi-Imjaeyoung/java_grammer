package C14Interface.BankService;

import java.math.BigDecimal;

public interface BankService {

    // 입금
    int withdraw(BankAccount now, int input);

    // 출금
    int deposit(BankAccount now, int input);
}
