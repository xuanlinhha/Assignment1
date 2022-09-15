package org.example.program_state;

import org.example.storage.Messages;

import java.util.Scanner;

public class R001State implements PState {
    private static final String STATE_TITLE = "----DEALER----";
    private static final String OPTION_0 = "0-Logout";
    private static final String OPTION_1 = "1-Print all dealers";
    private static final String OPTION_2 = "2-Add/Update a dealer";
    private static final String OPTION_3 = "3-Remove a dealer by ID";
    private static final String OPTION_5 = "4-Search dealers by name";
    private ServiceDiscovery sd;
    public R001State() {}

    public R001State(ServiceDiscovery sd) {
        this.sd = sd;
    }
    @Override
    public PState run() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println(STATE_TITLE);
            System.out.println(OPTION_0);
            System.out.println(OPTION_1);
            System.out.println(OPTION_2);
            System.out.println(SELECT_ONE_OPTION);
            String selection = myObj.nextLine();
            PState nextState = null;
            switch (selection) {
                case "0": {
                    nextState = new InitialState(sd);
                    break;
                }
                case "1": {
                    sd.getDealerService().printAll();
                    break;
                }
                // TODO: handle other options
                default: {
                    System.out.println(Messages.NOT_AVAILABLE_OPTION);
                }
            }
            if (nextState != null) return nextState;
        }
    }
}
