package terminal;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

import terminal.user_menu.*;


public class TerminalServer {
    Scanner scanner;
    private int account = 0;
    private ShowMessage showMessage = new ShowMessage();
    private RandomException randomException = new RandomException();


    public int getAccount() {
        return account;
    }

/*
*Метод проверяющий кратность введенного числа ста, считающий операции.
*
 */
    public void setAccount (String message, BiFunction<Integer, Integer, Integer> biFunction) {
        showMessage.print("Please enter value: ");
        String input = this.scanner.nextLine();  //Ввод суммы которую хотим внести
        if (Integer.valueOf(input) % 100==0) {  //Проверка на кратность ста.

            this.account = biFunction.apply(this.account, Integer.valueOf(input));
            showMessage.print(message + Integer.valueOf(input) +  ". Total: " + this.account);
            this.scanner.nextLine();

        } else {

            showMessage.print("Enter number multiple one hundred");
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
        List<MenuValue> menuValues = new ArrayList<>();
        menuValues.add(new MenuValue("1", () -> {
            showMessage.print("On your account: " + getAccount());
            showMessage.printPressAnyKey();
        }));
        menuValues.add(new MenuValue("2",() ->
                setAccount("Add to your account: ", (x,y) -> x + y)));
        menuValues.add(new MenuValue("3", () ->
                setAccount("Withdraw from your account: ", (x,y) -> x - y)));

        for (MenuValue m:menuValues) {                  //Перебор элементов списка
            if (m.getNumOfChoise().equals(input)) {     //Сравниваем введенное значение с полем объекта MenuValue
                m.getRunnable().run();
                break;
            }
        }
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


