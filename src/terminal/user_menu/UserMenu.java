package terminal.user_menu;

import java.util.Scanner;
import terminal.TerminalServer;

public interface UserMenu {
    Runnable TheActionWhenChoosing (TerminalServer terminalServer, ShowMessage showMessage);
}
