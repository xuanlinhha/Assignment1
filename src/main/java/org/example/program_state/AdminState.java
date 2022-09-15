package org.example.program_state;

import org.example.storage.Messages;

import java.util.Scanner;

public class AdminState implements PState {
    private static final String STATE_TITLE = "----ADMIN----";
    private static final String MSG = "This module is not available!";
    private static final String OPTION_0 = "0-Logout";
    private ServiceDiscovery sd;
    public AdminState() {}
    public AdminState(ServiceDiscovery sd) {
        this.sd = sd;
    }

    @Override
    public PState run() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println(STATE_TITLE);
            System.out.println(OPTION_0);
            System.out.println(SELECT_ONE_OPTION);
            String selection = myObj.nextLine();
            PState nextState = null;
            switch (selection) {
                case "0": {
                    nextState = new InitialState(sd);
                    break;
                }
                default: {
                    System.out.println(Messages.NOT_AVAILABLE_OPTION);
                }
            }
            if (nextState != null) return nextState;
        }
    }

    public ServiceDiscovery getSd() {
        return sd;
    }

    public void setSd(ServiceDiscovery sd) {
        this.sd = sd;
    }
}
