package C14Interface.BankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 서비스 객체는 계속 선언 할 이유가 없다. == 싱글 톤
// 싱글톤이 가능한 객체가 중요하다.
// 객체 생성은 어디서 할 것인가에 대한 이슈.

public class BankController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> bankAccountLists = new ArrayList<>();
        while(true){
            System.out.println("계좌 생성은 1번 , 입출금 업무는 2번, 프로그램 종료 3번");
            String input = sc.nextLine();
            // 계좌 생성
            if(input.equals("1")) {
                System.out.println("생성 할 계좌 번호를 입력해 주세요.");
                input = sc.nextLine();
                bankAccountLists.add(new BankAccount(input));
                System.out.println("계좌 생성이 완료 되었습니다.");
            }else if(input.equals("2")){
                System.out.println("계좌 번호를 입력해 주세요");
                input = sc.nextLine();
                BankAccount myAccount = null;
                for(BankAccount nowBankAccount: bankAccountLists){
                    if(input.equals(nowBankAccount.getAccountNumber())){
                        myAccount = nowBankAccount;
                    }
                }
                if(myAccount==null){
                    System.out.println("입력하신 번호를 가진 계좌가 없습니다");
                    continue;
                }else{
                    while (true){
                        System.out.println("1번 카드 서비스 이용 , 2번 카카오 서비스 이용 , 3번 현재 계좌 업무 종료");
                        input = sc.nextLine();
                        if(input.equals("1")){
                            System.out.println("카드 서비스 입니다. 1번 입금, 2번 인출,3번 달러 환전");
                            // 다형성 이슈
                            BankCardService bankCardService = new BankCardService();
                            input = sc.nextLine();
                            if(input.equals("1")){
                                System.out.println("입금할 돈을 입력해주세요");
                                int inputMoney = Integer.parseInt(sc.nextLine());
                                bankCardService.deposit(myAccount,inputMoney);
                                System.out.println("입금 후 잔액은 : "+myAccount.getBalance().intValue());
                            }else if(input.equals("2")){
                                System.out.println("출금할 돈을 입력해주세요");
                                int inputMoney = Integer.parseInt(sc.nextLine());
                                if(bankCardService.withdraw(myAccount,inputMoney)==-1){
                                    System.out.println("잔액이 부족합니다");
                                }else{
                                    System.out.println("현재 잔액은 "+myAccount.getBalance().intValue());
                                }
                            }else if(input.equals("3")){
                                System.out.println("환전할 돈을 입력해주세요");
                                int inputMoney = Integer.parseInt(sc.nextLine());
                                System.out.println("환전된 달러는 : "+bankCardService.exchangeUSD(myAccount,inputMoney)+"달러");
                            }
                        }else if(input.equals("2")){
                            System.out.println("카카오 서비스 입니다. 1번 입금, 2번 인출");
                            BankService bankkapayService = new BankKapayService();
                            input = sc.nextLine();
                            if(input.equals("1")){
                                System.out.println("입금할 돈을 입력해주세요");
                                int inputMoney = Integer.parseInt(sc.nextLine());
                                bankkapayService.deposit(myAccount,inputMoney);
                                System.out.println("입금 후 잔액은 : "+myAccount.getBalance().intValue());
                            }else if(input.equals("2")){
                                System.out.println("출금할 돈을 입력해주세요");
                                int inputMoney = Integer.parseInt(sc.nextLine());
                                if(bankkapayService.withdraw(myAccount,inputMoney)==-1){
                                    System.out.println("잔액이 부족합니다");
                                }else{
                                    System.out.println("현재 잔액은 "+myAccount.getBalance().intValue());
                                }
                            }
                        }else if(input.equals("3")){
                            break;
                        }
                    }

                }
            }else if(input.equals("3")){
                break;
            }

        }

    }
}
