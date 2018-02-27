package terminal.user_menu;

public class MenuValue {
    String numOfChoise;
    UserMenu userMenu;

    public MenuValue(String numOfChoise, UserMenu userMenu) {
        this.numOfChoise = numOfChoise;
        this.userMenu = userMenu;
    }

    public String getNumOfChoise() {
        return numOfChoise;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

}
