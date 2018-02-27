package terminal.user_menu;


public class ShowMessage {

    // Меню
    public final void menu() {
        System.out.println("=====================");
        System.out.println("Please enter command:");
        System.out.println("1 - check account");
        System.out.println("2 - add money");
        System.out.println("3 - take money");
        System.out.println("4 - quit");
        System.out.println("=====================");
    }


    public final void print(String message) {
        System.out.println(message);
    }

    public final void printPressAnyKey() {
        System.out.println("Press any key");
    }

}
