package terminal.user_menu;

import terminal.TerminalServer;

public class WithdrawCash implements UserMenu{

    public Runnable TheActionWhenChoosing (TerminalServer terminalServer, ShowMessage showMessage) {
        return () -> {
            terminalServer.setAccount("Withdraw from your account: ", (x,y) -> x - y);
            System.out.println("hellow");
        };
    }

}
