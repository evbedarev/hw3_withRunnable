package terminal;

import pin_processor.PinValidator;

import java.util.Scanner;

public class TerminalImpl {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private Scanner scanner = new Scanner(System.in);

    private TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }


    private void run() {
        String input;

        for (; ; ) {

            System.out.println("Please enter pin code. For quit press 'q': ");

            try {

                input = scanner.nextLine();
                if (input.equals("q")) {
                    break;
                }

                if (pinValidator.validatePin(input)) {
                        server.runTerminal(scanner);
                }

            } catch (NetworkProblemException|HardwareProblemException e) {
                server.sleep(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PinValidator());
        try {
            terminal.run();
        } finally {
            terminal.scanner.close();

        }

    }
}


