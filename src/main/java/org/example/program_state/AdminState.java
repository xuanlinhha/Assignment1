package org.example.program_state;

import java.util.Scanner;

public class AdminState implements PState {
    private static final String MSG = "Admin module not available";
    private static final String OPTION_1 = "0-Logout";
    private ServiceDiscovery sd;
    public AdminState() {}
    public AdminState(ServiceDiscovery sd) {
        this.sd = sd;
    }

    @Override
    public PState move() {
        System.out.println(MSG);
        System.out.println(SEPARATING_LINE);
        System.out.println(OPTION_1);
        System.out.println(SELECT_ONE);
        Scanner myObj = new Scanner(System.in);
        String selection = myObj.nextLine();
        PState nextState = this;
        if (selection.equals("0")) {
            nextState = new InitialState(sd);
        }
        return nextState;
    }

    public ServiceDiscovery getSd() {
        return sd;
    }

    public void setSd(ServiceDiscovery sd) {
        this.sd = sd;
    }
}
