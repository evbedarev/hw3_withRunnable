package terminal.user_menu;

import terminal.TerminalServer;


public class ShowAccount implements UserMenu {

    ShowMessage showMessage = new ShowMessage();

   public Runnable TheActionWhenChoosing (TerminalServer terminalServer, ShowMessage showMessage) {
        return () -> {
            showMessage.print("On your account: " + terminalServer.getAccount());
            showMessage.printPressAnyKey();
        };
    }
}