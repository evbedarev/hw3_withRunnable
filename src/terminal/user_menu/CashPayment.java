package terminal.user_menu;

import terminal.TerminalServer;

public class CashPayment implements UserMenu{

    public Runnable TheActionWhenChoosing (TerminalServer terminalServer, ShowMessage showMessage) {
        return () -> {
            terminalServer.setAccount("Add to your account: ", (x,y) -> x + y);
        };
    }
}
