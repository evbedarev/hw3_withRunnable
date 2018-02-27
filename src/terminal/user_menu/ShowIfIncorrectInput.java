package terminal.user_menu;

import terminal.TerminalServer;

public class ShowIfIncorrectInput implements UserMenu {
    public Runnable TheActionWhenChoosing (TerminalServer terminalServer, ShowMessage showMessage) {
        return ()-> System.out.println("Error. Please enter nubmer");
    }
}
