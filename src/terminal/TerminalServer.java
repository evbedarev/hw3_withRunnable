package terminal;

import java.util.*;
import java.util.function.BiFunction;

import terminal.user_menu.*;


public class TerminalServer {
    Scanner scanner;
    private int account = 0;
    private ShowMessage showMessage = new ShowMessage();
    private RandomException randomException = new RandomException();


    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        if (account > 0) {
            this.account = account;
        } else {
            System.out.println();
        }
    }

    /*
*Метод проверяющий кратность введенного числа ста, считающий операции.
*
 */
    public void setAccount (String message, BiFunction<Integer, Integer, Integer> biFunction) {
        showMessage.print("Please enter value: ");
        String input = this.scanner.nextLine();  //Ввод суммы которую хотим внести

        if ((Integer.valueOf(input) % 100==0) && ((biFunction.apply(this.account, Integer.valueOf(input))) > 0)) {  //Проверка на кратность ста.
            setAccount(biFunction.apply(this.account, Integer.valueOf(input)));
            showMessage.print(message + Integer.valueOf(input) +  ". Total: " + this.account);
            this.scanner.nextLine();
        }

        if ((biFunction.apply(this.account, Integer.valueOf(input))) < 0) {
            System.out.println("Not enough money. ");
        }


        if (Integer.valueOf(input) % 100!=0) {
            System.out.println("Enter number multiple one hundred");
        }

        showMessage.printPressAnyKey();
    }

/*
Основной метод терминала, бесконечный цикл с выходом если пользователь ввёл 4.
Сравнивает введенное значение со значением enum, если значения совпадает вызывается метод enum.value
Обрабатывает NumberFormatException, всё остальное пробрасывает.
 */


    public void runTerminal (Scanner scanner) throws Exception {

        this.scanner = scanner;

        for (;;) {
            showMessage.menu();                                 //Отображает меню.
            String input = this.scanner.nextLine();
            try {
                randomException.random();                       //Создаем свои исключения
                if (input.equals("4")) {break;}
                logicMenu(input);
            } catch (NumberFormatException e) {
                sleep("Error. Please enter nubmer");
            }
        }
    }

/*
*   Логика меню.
*   Создается список объектов MenuValue.
 */
    private void logicMenu(String input) {
        Map<String,Runnable> menuValueMap = new HashMap<>();
        menuValueMap.put("1",() -> {
                            showMessage.print("On your account: " + getAccount());
                            showMessage.printPressAnyKey();
                        });
        menuValueMap.put("2", () ->
                setAccount("Add to your account: ", (x,y) -> x + y));
        menuValueMap.put("3", () ->
                setAccount("Withdraw from your account: ", (x,y) -> x - y));
        if(menuValueMap.containsKey(input)) {menuValueMap.get(input).run();}
    }



    public final void sleep(String msg) {
        try {
            System.out.println(msg);
            Thread.sleep(3000);
        } catch (InterruptedException v) {
            System.out.println(v);
        }

    }

}


