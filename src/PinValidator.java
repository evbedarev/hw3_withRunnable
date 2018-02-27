
public class PinValidator {
    private final String pinCode = "1234";
    private int countInputPin =0;
    private boolean accountIsLocked = false;
    private int timer;

/*
*Проверка пина. Если аккаунт заблокирован и счётчик неудачных попыток равен 2 генерирует искючение.
* Если введен неверно пин <3 вызывает метод countEqualThree
* Если введен верно возвращает True
 */
    public boolean validatePin(String userPinCode) {
        try {

            if (accountIsLocked && countInputPin == 2) {
                throw new AccountIsLockedException("Account is locked. Time left: " + getTimer() + " seconds");
            }

            if (userPinCode.equals(pinCode)) {

                System.out.println("Pin is valid");

            } else {

                countEqualThree();
            }
            return userPinCode.equals(pinCode);

        } catch (AccountIsLockedException e) {

            System.out.println(e.getStackTrace());
        }
        return false;
    }

    private int getCountInputPin() {
        return countInputPin;
    }

    private void setCountInputPin(int countInputPin) {
        this.countInputPin = countInputPin;
    }

    private int getTimer() {
        return timer;
    }

    /*
    *Устанавливает значение accountIsLocked = true. Создает отдельный поток таймера, который
    * каждую секунду декрементирует переменную timer.
    *
     */

    private void setAccountIsLocked() {
        this.accountIsLocked = true;

        new Thread(() ->{

            try {

                for (this.timer=5;this.timer>0;this.timer--) {
                    Thread.sleep(1000);
                }

                this.accountIsLocked = false;
                countInputPin = 0;

            } catch (InterruptedException v) {

                System.out.println(v);
            }

        }).start();
    }

    /*
    *Проверяет счётчик неудачных попыток ввода пина. Если равен 2 то выдает сообщение и запускает
    * метод setAccountIsLocked(). В ином случает инкрементирует счётчик и выдает сообщение
    *
     */
    private void countEqualThree () {

        if (getCountInputPin() >=2) {

            System.out.println("Account is locked.");
            this.setAccountIsLocked();


        } else {

            this.setCountInputPin(getCountInputPin() + 1);
            System.out.println("Pin is not valid, please try more...");
        }

    }

}

class AccountIsLockedException extends Exception {
    AccountIsLockedException(String s) {
        super(s);
    }
}
