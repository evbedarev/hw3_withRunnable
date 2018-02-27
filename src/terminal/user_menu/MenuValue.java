package terminal.user_menu;

public class MenuValue {
    String numOfChoise;
    Runnable runnable;

    public MenuValue(String numOfChoise, Runnable runnable) {
        this.numOfChoise = numOfChoise;
        this.runnable = runnable;
    }

    public String getNumOfChoise() {
        return numOfChoise;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}
